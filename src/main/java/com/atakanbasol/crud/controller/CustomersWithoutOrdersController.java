package com.atakanbasol.crud.controller;

import com.atakanbasol.crud.dto.CustomerOrderDTO;
import com.atakanbasol.crud.service.CustomersWithoutOrdersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomersWithoutOrdersController {
    private final CustomersWithoutOrdersService customersWithoutOrdersService;

    public CustomersWithoutOrdersController(CustomersWithoutOrdersService customersWithoutOrdersService) {
        this.customersWithoutOrdersService = customersWithoutOrdersService;
    }

    @GetMapping("/withoutOrders")
    public ResponseEntity<List<CustomerOrderDTO>> getCustomersWithoutOrders() {
        List<CustomerOrderDTO> customers = customersWithoutOrdersService.getCustomersWithoutOrders();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
}
