package com.aquakloud.PosSystem.util.mappers;

import com.aquakloud.PosSystem.dto.CustomerDTO;
import com.aquakloud.PosSystem.entity.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDTO entityToDto (Customer customer);
    List<CustomerDTO> entityListToDTOList (List<Customer> customers);
}
