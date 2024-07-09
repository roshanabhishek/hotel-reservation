package com.myporeject.hotel_reservation.repository;

import com.myporeject.hotel_reservation.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
