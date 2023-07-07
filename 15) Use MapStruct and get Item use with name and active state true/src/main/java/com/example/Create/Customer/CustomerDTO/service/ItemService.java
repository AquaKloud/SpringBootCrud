package com.example.Create.Customer.CustomerDTO.service;


import com.example.Create.Customer.CustomerDTO.dto.ItemDTO;
import com.example.Create.Customer.CustomerDTO.dto.request.ItemSaveRequestDTO;
import com.example.Create.Customer.CustomerDTO.dto.request.ItemUpdateDTO;
import com.example.Create.Customer.CustomerDTO.dto.response.ItemGetResponseDTO;

import java.util.List;

public interface ItemService {
    String saveItem(ItemSaveRequestDTO itemSaveRequestDTO);

    ItemDTO getItemById(int itemId);

    String updateItem(ItemUpdateDTO itemUpdateDTO);

    List<ItemGetResponseDTO> getItemByNameAndStatusByMapstruct(String name);
}
