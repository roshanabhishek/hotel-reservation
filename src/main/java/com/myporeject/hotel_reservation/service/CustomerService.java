package com.myporeject.hotel_reservation.service;

import com.myporeject.hotel_reservation.entity.Customer;
import com.myporeject.hotel_reservation.exception.ResourceNotFoundException;
import com.myporeject.hotel_reservation.exception.UniqueConstraintViolationException;
import com.myporeject.hotel_reservation.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + id));
    }

    public Customer saveCustomer(Customer customer) {
        try {
            return customerRepository.save(customer);
        } catch (DataIntegrityViolationException ex) {
            throw new UniqueConstraintViolationException("Email address already in use.");
        }
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}

