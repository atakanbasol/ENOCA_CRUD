package com.atakanbasol.crud.controller;

import com.atakanbasol.crud.dto.CustomerOrderDTO;
import com.atakanbasol.crud.service.OrderAfterDateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderAfterDateController {
    private final OrderAfterDateService orderAfterDateService;

    public OrderAfterDateController(OrderAfterDateService orderAfterDateService) {
        this.orderAfterDateService = orderAfterDateService;
    }

    @GetMapping("/after/{date}")
    public ResponseEntity<List<CustomerOrderDTO>> getOrdersAfterDate(@PathVariable("date") String date) {
        LocalDate startDate = LocalDate.parse(date);
        List<CustomerOrderDTO> orders = orderAfterDateService.getOrdersAfterDate(startDate);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}
