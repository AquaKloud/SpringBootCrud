package com.example.Create.Customer.CustomerDTO.controller;

import com.example.Create.Customer.CustomerDTO.dto.ItemDTO;
import com.example.Create.Customer.CustomerDTO.dto.request.ItemSaveRequestDTO;
import com.example.Create.Customer.CustomerDTO.dto.request.ItemUpdateDTO;
import com.example.Create.Customer.CustomerDTO.dto.response.ItemGetResponseDTO;
import com.example.Create.Customer.CustomerDTO.service.ItemService;
import com.example.Create.Customer.CustomerDTO.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {
    @Autowired
    private ItemService itemService;

//    @PostMapping(
//            path = "/save"
//    )
//    public String saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO){
//
//       String message = itemService.saveItem(itemSaveRequestDTO);
//       return "saved";
//    }

//    @PostMapping(
//            path = "/save"
//    )
//    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO){
//        String message = itemService.saveItem(itemSaveRequestDTO);
//        StandardResponse standardResponse = new StandardResponse(
//                201,
//                "Item Saved Successfull",
//                message
//        );
//        ResponseEntity<StandardResponse> response = new ResponseEntity<StandardResponse>(
//                standardResponse, HttpStatus.CREATED
//        );
//        return response;
//    }

    @PostMapping(
           path = "/save"
    )
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO){
        String message = itemService.saveItem(itemSaveRequestDTO);

         return new ResponseEntity<StandardResponse>(
               new StandardResponse(201,"Item Saved Successfull",itemSaveRequestDTO),
               HttpStatus.OK
         );
    }



//    @GetMapping(
//            path = "/get-by-id",
//            params = "id"
//    )
//
//    public ItemDTO getItemById(@RequestParam(value = "id")int itemId ){
//        ItemDTO itemDTO = itemService.getItemById(itemId);
//        return itemDTO;
//    }

    @GetMapping(
            path = "/get-by-id",
            params = "id"
    )
    public ResponseEntity<StandardResponse> getItemById(@RequestParam(value = "id")int itemId ){
           ItemDTO itemDTO = itemService.getItemById(itemId);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",itemDTO),
                HttpStatus.CREATED
        );
    }

    @PutMapping(path = "/update-item")
    public String updateItem(@RequestBody ItemUpdateDTO itemUpdateDTO){
        String message = itemService.updateItem(itemUpdateDTO);
        return message;
    }

    @GetMapping(
            path = "/get-by-name-with-mapstruct",
            params = "name"
    )

    public List<ItemGetResponseDTO> getItemByNameAndStatusByMapstruct(@RequestParam(value = "name") String name){
        List<ItemGetResponseDTO> itemGetResponseDTOS = itemService.getItemByNameAndStatusByMapstruct(name);
        return itemGetResponseDTOS;
    }


}
