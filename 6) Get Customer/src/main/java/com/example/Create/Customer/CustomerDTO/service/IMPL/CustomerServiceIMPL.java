package com.example.Create.Customer.CustomerDTO.service.IMPL;

import com.example.Create.Customer.CustomerDTO.dto.CustomerDTO;
import com.example.Create.Customer.CustomerDTO.dto.request.CustomerUpdateDTO;
import com.example.Create.Customer.CustomerDTO.entity.Customer;
import com.example.Create.Customer.CustomerDTO.repo.CustomerRepo;
import com.example.Create.Customer.CustomerDTO.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        if(customerRepo.existsById(customerUpdateDTO.getCustomerId())){
            Customer customer = customerRepo.getReferenceById(customerUpdateDTO.getCustomerId());

            customer.setCustomerName(customerUpdateDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
            customer.setNic(customerUpdateDTO.getNic());

            customerRepo.save(customer);
            return customerUpdateDTO.getCustomerName() + "Update";
        }else{
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
}
