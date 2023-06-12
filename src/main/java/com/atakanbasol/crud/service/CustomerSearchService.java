package com.atakanbasol.crud.service;

import com.atakanbasol.crud.data.entity.CustomerEntity;
import com.atakanbasol.crud.data.entity.OrderEntity;
import com.atakanbasol.crud.data.repository.CustomerRepository;
import com.atakanbasol.crud.dto.CustomerOrderDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerSearchService {
    private final CustomerRepository customerRepository;

    public CustomerSearchService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerOrderDTO> searchCustomersByName(String keyword) {
        List<CustomerEntity> customers = customerRepository.findByNameContaining(keyword);
        return customers.stream()
                .map(this::mapToCustomerOrderDTO)
                .collect(Collectors.toList());
    }

    private CustomerOrderDTO mapToCustomerOrderDTO(CustomerEntity customer) {
        return new CustomerOrderDTO(customer.getName(), customer.getOrders().stream()
                .findFirst()
                .map(OrderEntity::getId)
                .orElse(null));
    }
}
