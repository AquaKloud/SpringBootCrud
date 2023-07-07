package com.example.Create.Customer.CustomerDTO.controller;

import com.example.Create.Customer.CustomerDTO.dto.ItemDTO;
import com.example.Create.Customer.CustomerDTO.dto.request.ItemSaveRequestDTO;
import com.example.Create.Customer.CustomerDTO.dto.request.ItemUpdateDTO;
import com.example.Create.Customer.CustomerDTO.dto.response.ItemGetResponseDTO;
import com.example.Create.Customer.CustomerDTO.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping(
            path = "/save"
    )
    public String saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO){

       String message = itemService.saveItem(itemSaveRequestDTO);
       return "saved";
    }

    @GetMapping(
            path = "/get-by-id",
            params = "id"
    )

    public ItemDTO getItemById(@RequestParam(value = "id")int itemId ){
        ItemDTO itemDTO = itemService.getItemById(itemId);
        return itemDTO;
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
