package com.springbootacademy.batch9pos.controller;

import com.springbootacademy.batch9pos.dto.CustomerDTO;
import com.springbootacademy.batch9pos.dto.request.CustomerUpdateDTO;
import com.springbootacademy.batch9pos.service.CustomerService;
import com.springbootacademy.batch9pos.service.impl.CustomerServiceIMPL;
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
       // CustomerService customerService = new CustomerService();
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
    public String deleteCustomer(@PathVariable(value = "id") int customerId){
        String deleted = customerService.deleteCustomer(customerId);
        return deleted;
    }

    @GetMapping (
            path = "get-all-customers"
    )
    public List<CustomerDTO> getAllCustomer(){
        List<CustomerDTO> customerDTOS = customerService.getAllCustomer();
        return customerDTOS;
    }

}
