package com.example.Create.Customer.CustomerDTO.util.mappers;

import com.example.Create.Customer.CustomerDTO.dto.response.ItemGetResponseDTO;
import com.example.Create.Customer.CustomerDTO.entity.Item;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    List<ItemGetResponseDTO> entityListToDtoList(List<Item> items);
}
