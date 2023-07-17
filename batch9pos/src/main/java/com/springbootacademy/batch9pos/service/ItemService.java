package com.springbootacademy.batch9pos.service;

import com.springbootacademy.batch9pos.dto.ItemDTO;
import com.springbootacademy.batch9pos.dto.request.ItemSaveRequestDTO;
import com.springbootacademy.batch9pos.dto.request.ItemUpdateDTO;

import java.util.List;

public interface ItemService  {
    String saveItem(ItemSaveRequestDTO itemSaveRequestDTO);

    ItemDTO getItemById(int itemId);

    String updateItem(ItemUpdateDTO itemUpdateDTO);

    String deleteItem(int itemId);

    List<ItemDTO> getAllItemByActiveState(boolean activeStatus);

    List<ItemDTO> getAllItem();
}
