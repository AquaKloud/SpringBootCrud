package com.example.Create.Customer.CustomerDTO.service;


import com.example.Create.Customer.CustomerDTO.dto.ItemDTO;
import com.example.Create.Customer.CustomerDTO.dto.request.ItemSaveRequestDTO;

public interface ItemService {
    String saveItem(ItemSaveRequestDTO itemSaveRequestDTO);

    ItemDTO getItemById(int itemId);
}
