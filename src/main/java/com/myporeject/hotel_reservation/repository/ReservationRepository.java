package com.myporeject.hotel_reservation.repository;

import com.myporeject.hotel_reservation.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}