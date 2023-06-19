package com.springbootacademy.batch9pos.service;

import com.springbootacademy.batch9pos.dto.CustomerDTO;
import com.springbootacademy.batch9pos.dto.request.CustomerUpdateDTO;

import java.util.List;

public interface CustomerService {


    public String saveCustomer(CustomerDTO customerDTO);

    String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    CustomerDTO getCustomerById(int customerId);

    String deleteCustomer(int customerId);

    List<CustomerDTO> getAllCustomer();
}
