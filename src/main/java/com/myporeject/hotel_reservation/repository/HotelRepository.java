package com.myporeject.hotel_reservation.repository;

import com.myporeject.hotel_reservation.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long>, PagingAndSortingRepository<Hotel, Long> {
}
