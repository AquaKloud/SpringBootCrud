package com.example.Create.Customer.CustomerDTO.service;


import com.example.Create.Customer.CustomerDTO.dto.ItemDTO;
import com.example.Create.Customer.CustomerDTO.dto.request.ItemSaveRequestDTO;
import com.example.Create.Customer.CustomerDTO.dto.request.ItemUpdateDTO;

public interface ItemService {
    String saveItem(ItemSaveRequestDTO itemSaveRequestDTO);

    ItemDTO getItemById(int itemId);

    String updateItem(ItemUpdateDTO itemUpdateDTO);
}
