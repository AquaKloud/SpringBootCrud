package com.springbootacademy.batch9pos.controller;

import com.springbootacademy.batch9pos.dto.CustomerDTO;
import com.springbootacademy.batch9pos.dto.ItemDTO;
import com.springbootacademy.batch9pos.dto.request.ItemSaveRequestDTO;
import com.springbootacademy.batch9pos.dto.request.ItemUpdateDTO;
import com.springbootacademy.batch9pos.service.ItemService;
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
    public ItemDTO getItemById(@RequestParam(value = "id") int itemId){
        ItemDTO itemDTO = itemService.getItemById(itemId);
        return itemDTO;
    }

    @PutMapping(path = "/update-item")
    public String updateItem(@RequestBody ItemUpdateDTO itemUpdateDTO){
        String message = itemService.updateItem(itemUpdateDTO);
        return message;
    }

    @DeleteMapping(
            path ="/delete-item/{id}"
    )
    public String deleteItem(@PathVariable(value = "id") int itemId){
        String deleted = itemService.deleteItem(itemId);
        return deleted;
    }

    @GetMapping (
            path = "get-all-item-by-active-state/{status}"
    )
    public List<ItemDTO> getAllItemByActiveState(@PathVariable(value = "status") boolean activeStatus){
        List<ItemDTO> itemDTOS = itemService.getAllItemByActiveState(activeStatus);
        return itemDTOS;
    }

    @GetMapping (
            path = "get-all-item"
    )
    public List<ItemDTO> getAllItem(){
        List<ItemDTO> itemDTOS = itemService.getAllItem();
        return itemDTOS;
    }

}
