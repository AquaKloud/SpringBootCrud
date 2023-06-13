package com.example.Create.Customer.CustomerDTO.service;

import com.example.Create.Customer.CustomerDTO.dto.CustomerDTO;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    public String saveCustomer(CustomerDTO customerDTO){
        return "Saved Customer";
    }
}
