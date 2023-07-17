package com.aquakloud.PosSystem.service.serviceIMPL;

import com.aquakloud.PosSystem.dto.CustomerDTO;
import com.aquakloud.PosSystem.dto.request.CustomerSaveRequestDTO;
import com.aquakloud.PosSystem.dto.response.CustomerUpdateDTO;
import com.aquakloud.PosSystem.entity.Customer;
import com.aquakloud.PosSystem.repo.CustomerRepo;
import com.aquakloud.PosSystem.service.CustomerService;
import com.aquakloud.PosSystem.util.mappers.CustomerMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerMapper customerMapper;


    @Override
    public String saveCustomer(CustomerSaveRequestDTO customerSaveRequestDTO) {

        Customer customer = modelMapper.map(customerSaveRequestDTO,Customer.class);
        customerRepo.save(customer);
        return customer.getCustomerName();
    }

    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        if (customerRepo.existsById(customerUpdateDTO.getCustomerId())) {

            Customer customer = modelMapper.map(customerUpdateDTO, Customer.class);
            customerRepo.save(customer);
            return customerUpdateDTO.getCustomerName() + "Update Item";

        }else{
            throw new RuntimeException("No Data Found for that id");
        }
    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {
        if(customerRepo.existsById(customerId)){
            Customer customer = customerRepo.getReferenceById(customerId);
            CustomerDTO customerDTO = customerMapper.entityToDto(customer);
            return customerDTO;
        }else{
            throw new RuntimeException("No Customer");
        }

    }

    @Override
    public String deleteCustomer(int customerId) {
        if(customerRepo.existsById(customerId)){
            customerRepo.deleteById(customerId);
            return customerId + "Deleted";
        }else{
            throw new RuntimeException("No Customer for Deleted");
        }

    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        List<Customer> customerList = customerRepo.findAll();
        List<CustomerDTO> customerDTOList = customerMapper.entityListToDTOList(customerList);
        return customerDTOList;
    }

    @Override
    public List<CustomerDTO> getAllCustomersByActiveState(boolean activeStatus) {
        List<Customer> customerList = customerRepo.findAllByActiveState(activeStatus);
        List<CustomerDTO> customerDTOList = customerMapper.entityListToDTOList(customerList);
        return customerDTOList;
    }
}
