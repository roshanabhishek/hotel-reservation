package com.myporeject.hotel_reservation.repository;

import com.myporeject.hotel_reservation.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}

