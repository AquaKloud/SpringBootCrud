package com.aquakloud.PosSystem.service;

import com.aquakloud.PosSystem.dto.CustomerDTO;
import com.aquakloud.PosSystem.dto.request.CustomerSaveRequestDTO;
import com.aquakloud.PosSystem.dto.response.CustomerUpdateDTO;

import java.util.List;

public interface CustomerService {


    String saveCustomer(CustomerSaveRequestDTO customerSaveRequestDTO);

    String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    CustomerDTO getCustomerById(int customerId);

    String deleteCustomer(int customerId);

    List<CustomerDTO> getAllCustomer();

    List<CustomerDTO> getAllCustomersByActiveState(boolean activeStatus);
}
    
  
