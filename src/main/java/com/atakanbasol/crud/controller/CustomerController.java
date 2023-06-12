package com.atakanbasol.crud.controller;

import com.atakanbasol.crud.data.entity.CustomerEntity;
import com.atakanbasol.crud.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public ResponseEntity<CustomerEntity> addCustomer(@RequestBody CustomerEntity customer){
        CustomerEntity addCustomer = customerService.addCustomer(customer);
        return  new ResponseEntity<CustomerEntity>(addCustomer, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CustomerEntity>> getAllCustomer(){
        List<CustomerEntity> allCustomer = customerService.findAllCustomer();
        return new ResponseEntity<List<CustomerEntity>>(allCustomer,HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<CustomerEntity> getCustomerId(@PathVariable("id") Long id){
        CustomerEntity customerById = customerService.getCustomerById(id);
        return new ResponseEntity<CustomerEntity>(customerById,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable("id") Long id){
        customerService.deleteCustomerById(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
    @PutMapping("/update")
    public ResponseEntity<CustomerEntity> updateCustomer(@RequestBody CustomerEntity customer) {
        CustomerEntity updatedCustomer = customerService.updateCustomer(customer);
        if (updatedCustomer != null) {
            return new ResponseEntity<CustomerEntity>(updatedCustomer, HttpStatus.OK);
        } else {
            return new ResponseEntity<CustomerEntity>(HttpStatus.NOT_FOUND);
        }
    }

}
