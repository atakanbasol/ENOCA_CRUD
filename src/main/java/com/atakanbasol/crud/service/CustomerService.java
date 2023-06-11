package com.atakanbasol.crud.service;

import com.atakanbasol.crud.data.entity.CustomerEntity;
import com.atakanbasol.crud.data.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerEntity addCustomer(CustomerEntity customer){
        return customerRepository.save(customer);
    }

    public List<CustomerEntity> findAllCustomer(){
        return customerRepository.findAll();
    }

    public CustomerEntity getCustomerById(Long customerId){
        return customerRepository.findById(customerId).get();
    }

    public void deleteCustomerById(Long customerId){
        customerRepository.deleteById(customerId);
    }
    public CustomerEntity updateCustomer(CustomerEntity customer) {
        Optional<CustomerEntity> customerOptional = customerRepository.findById(customer.getId());
        if (customerOptional.isPresent()) {
            CustomerEntity existingCustomer = customerOptional.get();
            existingCustomer.setName(customer.getName());
            existingCustomer.setAge(customer.getAge());
            return customerRepository.save(existingCustomer);
        } else {
            // Güncellenecek müşteri bulunamadığında, gelen müşteri nesnesini geri döndürme
            return customer;
        }
    }
}