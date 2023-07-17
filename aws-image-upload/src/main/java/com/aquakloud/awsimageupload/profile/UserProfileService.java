package com.aquakloud.awsimageupload.profile;

import com.aquakloud.awsimageupload.bucket.BucketName;
import com.aquakloud.awsimageupload.filestore.FileStore;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class UserProfileService {

    private final UserProfileDataAccessService userProfileDataAccessService;
    private final FileStore fileStore;

    @Autowired
    public UserProfileService(UserProfileDataAccessService userProfileDataAccessService, FileStore fileStore) {
        this.userProfileDataAccessService = userProfileDataAccessService;
        this.fileStore = fileStore;
    }

    List<UserProfile> getUserProfiles() {
        return userProfileDataAccessService.getUserProfile();
    }

     void uploadUserProfileImage(UUID userProfileId, MultipartFile file) {

        // 1. Check if image is not empty
         isFileEmpty(file);

//         if(file.isEmpty()){
//             throw new IllegalStateException("cannot upload empty file ["+ file.getSize() +"]");
//         }

        // 2. If file is an image

         isImage(file);

//         if(!Arrays.asList(ContentType.IMAGE_JPEG.getMimeType(), ContentType.IMAGE_PNG.getMimeType(),IMAGE_GIF.getMimeType(),ContentType.IMAGE_GIF).contains(file.getContentType())){
//             throw new IllegalStateException("File must be an image [" + file.getSize() + "]");
//         }

        // 3. The user exists in our database
         UserProfile user = getUserProfileThrow(userProfileId);

//
//         UserProfile user = userProfileDataAccessService
//                 .getUserProfile()
//                 .stream()
//                 .filter(userProfile -> userProfile.getUserProfileId().equals(userProfileId))
//                 .findFirst()
//                 .orElseThrow(() -> new IllegalStateException((String.format("User profile %s not found", userProfileId))));

        // 4. Grab some metadata from file if any
         Map<String, String> metadata = extractMetadata(file);

//         Map<String, String> metadata = new HashMap<>();
//         metadata.put("Content-Type", file.getContentType());
//         metadata.put("Content-Length", String.valueOf(file.getSize()));

        // 5. Store the image in s3 and update database (userProfileImageLink) with s3 image link
        String path = String.format("%s/%s", BucketName.PROFILE_IMAGE.getBucketName(), user.getUserProfileId());
        String filename = String.format("%s-%s", file.getOriginalFilename(), UUID.randomUUID());

        try {
            fileStore.save(path, filename, Optional.of(metadata), file.getInputStream());
           // user.setUserProfileImageLink(filename);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private static Map<String, String> extractMetadata(MultipartFile file) {
        Map<String, String> metadata = new HashMap<>();
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-Length", String.valueOf(file.getSize()));
        return metadata;
    }

    private UserProfile getUserProfileThrow(UUID userProfileId) {
        UserProfile user = userProfileDataAccessService
                .getUserProfile()
                .stream()
                .filter(userProfile -> userProfile.getUserProfileId().equals(userProfileId))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException((String.format("User profile %s not found", userProfileId))));
        return user;
    }

    private static void isImage(MultipartFile file) {
        if(!Arrays.asList(ContentType.IMAGE_JPEG.getMimeType(),
                ContentType.IMAGE_PNG.getMimeType(),
                ContentType.IMAGE_GIF.getMimeType()).contains(file.getContentType())){
            throw new IllegalStateException("File must be an image [" + file.getSize() + "]");
        }
    }

    private static void isFileEmpty(MultipartFile file) {
        if(file.isEmpty()){
            throw new IllegalStateException("cannot upload empty file ["+ file.getSize() +"]");
        }
    }
}