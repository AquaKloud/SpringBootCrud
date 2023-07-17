package com.aquakloud.PosSystem.controller;

import com.aquakloud.PosSystem.dto.CustomerDTO;
import com.aquakloud.PosSystem.dto.request.CustomerSaveRequestDTO;
import com.aquakloud.PosSystem.dto.response.CustomerUpdateDTO;
import com.aquakloud.PosSystem.service.CustomerService;
import com.aquakloud.PosSystem.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/save-customer")
    public ResponseEntity<StandardResponse> saveCustomer(@RequestBody CustomerSaveRequestDTO customerSaveRequestDTO){
        String message = customerService.saveCustomer(customerSaveRequestDTO);
        return new ResponseEntity<StandardResponse>(
               new StandardResponse(201,"Item Saved Successfull",customerSaveRequestDTO),
                HttpStatus.OK
        );
    }

    @PutMapping(path = "/update-customer")
    public ResponseEntity<StandardResponse> updateCustomer(@RequestBody CustomerUpdateDTO  customerUpdateDTO){
        String message =  customerService.updateCustomer(customerUpdateDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Update Success",customerUpdateDTO),
                HttpStatus.OK
        );
    }

    @GetMapping(
            path = "/get-by-id",
            params = "id"
    )
    public ResponseEntity<StandardResponse> getCustomerById(@RequestParam(value = "id") int customerId){
        CustomerDTO customerDTO = customerService.getCustomerById(customerId);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Success",customerDTO),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping(
            path = "/delete-customer/{id}"
    )
    public String deleteCustomer(@PathVariable (value="id") int customerId){
        String deleted = customerService.deleteCustomer(customerId);
        return deleted;
    }



    @GetMapping(
            path = "get-all-customer"
    )
    public ResponseEntity<StandardResponse> getAllCustomer(){
       List<CustomerDTO> customerDTOS = customerService.getAllCustomer();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(202,"Success",customerDTOS),
                HttpStatus.OK
        );
    }

    @GetMapping(
            path = "get-all-customers-by-active-state/{status}"
    )
    public ResponseEntity<StandardResponse> getAllCustomersByActiveState(@PathVariable(value = "status") boolean activeStatus){
        List<CustomerDTO> customerDTOS = customerService.getAllCustomersByActiveState(activeStatus);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",customerDTOS),
                HttpStatus.OK
        );
    }

}
