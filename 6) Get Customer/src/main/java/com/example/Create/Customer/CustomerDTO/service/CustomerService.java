package com.example.Create.Customer.CustomerDTO.service;

import com.example.Create.Customer.CustomerDTO.dto.CustomerDTO;
import com.example.Create.Customer.CustomerDTO.dto.request.CustomerUpdateDTO;

public interface CustomerService {

    public String saveCustomer(CustomerDTO customerDTO);

    String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    CustomerDTO getCustomerById(int customerId);
}
