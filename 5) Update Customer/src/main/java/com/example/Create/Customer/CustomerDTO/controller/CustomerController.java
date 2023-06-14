package com.example.Create.Customer.CustomerDTO.controller;


import com.example.Create.Customer.CustomerDTO.dto.CustomerDTO;
import com.example.Create.Customer.CustomerDTO.dto.request.CustomerUpdateDTO;
import com.example.Create.Customer.CustomerDTO.service.CustomerService;
import com.example.Create.Customer.CustomerDTO.service.IMPL.CustomerServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin

public class CustomerController {

    @Autowired
    private CustomerServiceIMPL customerService;

    @PostMapping(path = "/save-customer")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO){
        //CustomerServiceIMPL customerService = new CustomerServiceIMPL();
        customerService.saveCustomer(customerDTO);
        return "saved";
    }

    @PutMapping(path = "/update-customer")
    public String updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO){
        String message = customerService.updateCustomer(customerUpdateDTO);
        return message;
    }
}
