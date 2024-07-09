package com.myporeject.hotel_reservation.controller;

import com.myporeject.hotel_reservation.entity.Customer;
import com.myporeject.hotel_reservation.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public ResponseEntity<Object> createCustomer(@Valid @RequestBody Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // If validation errors exist, return a bad request response with error messages
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }

        Customer createdCustomer = customerService.saveCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        customer.setId(id);
        return customerService.saveCustomer(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }
}

