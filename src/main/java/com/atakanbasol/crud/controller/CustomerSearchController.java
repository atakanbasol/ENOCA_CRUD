package com.atakanbasol.crud.controller;

import com.atakanbasol.crud.dto.CustomerOrderDTO;
import com.atakanbasol.crud.service.CustomerSearchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerSearchController {
    private final CustomerSearchService customerSearchService;

    public CustomerSearchController(CustomerSearchService customerSearchService) {
        this.customerSearchService = customerSearchService;
    }

    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<CustomerOrderDTO>> searchCustomersByName(@PathVariable("keyword") String keyword) {
        List<CustomerOrderDTO> results = customerSearchService.searchCustomersByName(keyword);
        return new ResponseEntity<>(results, HttpStatus.OK);
    }
}
