package com.atakanbasol.crud.service;

import com.atakanbasol.crud.data.entity.CustomerEntity;
import com.atakanbasol.crud.data.repository.CustomerRepository;
import com.atakanbasol.crud.dto.CustomerOrderDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CustomersWithoutOrdersService {
    private final CustomerRepository customerRepository;

    public CustomersWithoutOrdersService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerOrderDTO> getCustomersWithoutOrders() {
        List<CustomerEntity> customersWithoutOrders = customerRepository.findCustomersWithoutOrders();
        List<CustomerOrderDTO> customerOrderDTOs = new ArrayList<>();

        for (CustomerEntity customer : customersWithoutOrders) {
            CustomerOrderDTO customerOrderDTO = new CustomerOrderDTO();
            customerOrderDTO.setId(customer.getId());
            customerOrderDTO.setName(customer.getName());
            customerOrderDTO.setAge(customer.getAge());
            customerOrderDTOs.add(customerOrderDTO);
        }

        return customerOrderDTOs;
    }

    // Diğer servis yöntemleri buraya eklenebilir
}
