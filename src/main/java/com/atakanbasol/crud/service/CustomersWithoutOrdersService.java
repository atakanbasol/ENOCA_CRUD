package com.atakanbasol.crud.service;

import com.atakanbasol.crud.data.entity.CustomerEntity;
import com.atakanbasol.crud.data.repository.CustomerRepository;
import com.atakanbasol.crud.dto.CustomerOrderDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomersWithoutOrdersService {
    private final CustomerRepository customerRepository;

    public CustomersWithoutOrdersService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerOrderDTO> getCustomersWithoutOrders() {
        List<CustomerEntity> customers = customerRepository.findByOrdersIsNull();
        return customers.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private CustomerOrderDTO convertToDTO(CustomerEntity customer) {
        CustomerOrderDTO dto = new CustomerOrderDTO();
        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setAge(customer.getAge());
        return dto;
    }
}
