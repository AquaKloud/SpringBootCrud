package com.springbootacademy.batch9pos.service.impl;

import com.springbootacademy.batch9pos.dto.CustomerDTO;
import com.springbootacademy.batch9pos.dto.request.CustomerUpdateDTO;
import com.springbootacademy.batch9pos.entity.Customer;
import com.springbootacademy.batch9pos.repo.CustomerRepo;
import com.springbootacademy.batch9pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddress(),
                customerDTO.getContactNumber(),
                customerDTO.getNic(),
                customerDTO.isActiveState()
        );


        customerRepo.save(customer);
        return customer.getCustomerName() + "Saved";
    }

    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        if (customerRepo.existsById(customerUpdateDTO.getCustomerId())) {
            Customer customer = customerRepo.getReferenceById(customerUpdateDTO.getCustomerId());

            customer.setCustomerName(customerUpdateDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
            customer.setNic(customerUpdateDTO.getNic());

            customerRepo.save(customer);
            return customerUpdateDTO.getCustomerName() + "Update";
        } else {
            throw new RuntimeException("No Data Found for that id");
        }

    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {
      if(customerRepo.existsById(customerId)) {
          Customer customer = customerRepo.getReferenceById(customerId);
          CustomerDTO customerDTO = new CustomerDTO(
                  customer.getCustomerId(),
                  customer.getCustomerName(),
                  customer.getCustomerAddress(),
                  customer.getContactNumber(),
                  customer.getNic(),
                  customer.isActiveState()
          );
          return customerDTO;
      }else{
          throw new RuntimeException("No Customer");
      }
    }

    @Override
    public String deleteCustomer(int customerId) {
         if(customerRepo.existsById(customerId)){
             customerRepo.deleteById(customerId);
             return customerId + "deleted";
         }else{
             throw new RuntimeException("No Customer for delete");
         }
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        List<Customer> customerDTOList = customerRepo.findAll();
        List<CustomerDTO> customerDTOS = new ArrayList<>();

        for(Customer customer : customerDTOList){
            CustomerDTO customerDTO = new CustomerDTO(
              customer.getCustomerId(),
              customer.getCustomerName(),
              customer.getCustomerAddress(),
              customer.getContactNumber(),
              customer.getNic(),
              customer.isActiveState()
            );
            customerDTOS.add(customerDTO);
        }
        return customerDTOS;
    }

    @Override
    public List<CustomerDTO> getAllCustomerByActiveState(boolean activeStatus) {
        List<Customer> customerDTOList = customerRepo.findAllByActiveState(activeStatus);
        List<CustomerDTO> customerDTOS = new ArrayList<>();

        for(Customer customer : customerDTOList){
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getContactNumber(),
                    customer.getNic(),
                    customer.isActiveState()
            );
            customerDTOS.add(customerDTO);
        }
        return customerDTOS;
    }


}
