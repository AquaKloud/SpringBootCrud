package com.example.Create.Customer.CustomerDTO.controller;


import com.example.Create.Customer.CustomerDTO.dto.CustomerDTO;
import com.example.Create.Customer.CustomerDTO.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin


public class CustomerController {

    @Autowired
    private CustomerService customerService;


    public String saveCustomer(@RequestBody CustomerDTO customerDTO){
        CustomerService customerService = new CustomerService();
        customerService.saveCustomer(customerDTO);
        return "saved";
    }
}
