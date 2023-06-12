package com.atakanbasol.crud.service;

import com.atakanbasol.crud.data.entity.OrderEntity;
import com.atakanbasol.crud.data.repository.OrderRepository;
import com.atakanbasol.crud.dto.CustomerOrderDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderAfterDateService {
    private final OrderRepository orderRepository;

    public OrderAfterDateService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<CustomerOrderDTO> getOrdersAfterDate(LocalDate startDate) {
        List<OrderEntity> orders = orderRepository.findByOrderDateAfter(startDate);
        return orders.stream()
                .map(order -> new CustomerOrderDTO(order.getCustomer().getName(), order.getId()))
                .collect(Collectors.toList());
    }
}
