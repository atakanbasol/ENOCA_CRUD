package com.atakanbasol.crud.service;
import com.atakanbasol.crud.data.entity.OrderEntity;
import com.atakanbasol.crud.data.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public OrderEntity addOrder(OrderEntity order) {
        return orderRepository.save(order);
    }

    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }

    public OrderEntity getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public OrderEntity updateOrder(Long id, OrderEntity updatedOrder) {
        OrderEntity existingOrder = orderRepository.findById(id).orElse(null);
        if (existingOrder != null) {
            existingOrder.setCreateDate(updatedOrder.getCreateDate());
            existingOrder.setTotalPrice(updatedOrder.getTotalPrice());
            existingOrder.setCustomer(updatedOrder.getCustomer());
            return orderRepository.save(existingOrder);
        }
        return null;
    }

    public boolean deleteOrderById(Long id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
