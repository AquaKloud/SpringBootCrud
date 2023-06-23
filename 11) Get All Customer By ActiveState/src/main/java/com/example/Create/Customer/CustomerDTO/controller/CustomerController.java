package com.example.Create.Customer.CustomerDTO.controller;


import com.example.Create.Customer.CustomerDTO.dto.CustomerDTO;
import com.example.Create.Customer.CustomerDTO.dto.request.CustomerUpdateDTO;
import com.example.Create.Customer.CustomerDTO.service.CustomerService;
import com.example.Create.Customer.CustomerDTO.service.IMPL.CustomerServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin

public class CustomerController {

    @Autowired
    private CustomerService customerService;

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

    @GetMapping(
            path = "/get-by-id",
            params = "id"
    )
    public CustomerDTO getCustomerById(@RequestParam(value = "id") int customerId){
        CustomerDTO customerDTO = customerService.getCustomerById(customerId);
        return customerDTO;
    }

    @DeleteMapping(
            path ="/delete-customer/{id}"
    )
    public String deleteCustomer(@PathVariable (value="id") int customerId){
        String deleted = customerService.deleteCustomer(customerId);
        return deleted;
    }

    @GetMapping(
            path = "get-all-customers"
    )
    public List<CustomerDTO> getAllCustomer(){
        List<CustomerDTO> customerDTOS = customerService.getAllCustomer();
        return customerDTOS;
    }

    @GetMapping(
            path = "get-all-customers-by-active-state/{status}"
    )
    public List<CustomerDTO> getAllCustomerByActiveState(@PathVariable(value = "status") boolean activeStatus){
        List<CustomerDTO> customerDTOS = customerService.getAllCustomerByActiveState(activeStatus);
        return customerDTOS;
    }

}
