package com.myporeject.hotel_reservation.service;

import com.myporeject.hotel_reservation.exception.ResourceNotFoundException;
import com.myporeject.hotel_reservation.entity.Customer;
import com.myporeject.hotel_reservation.entity.Reservation;
import com.myporeject.hotel_reservation.entity.Room;
import com.myporeject.hotel_reservation.repository.CustomerRepository;
import com.myporeject.hotel_reservation.repository.ReservationRepository;
import com.myporeject.hotel_reservation.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RoomRepository roomRepository;


    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    public Reservation createReservation(Long customerId, Long roomId, Reservation reservation) {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + customerId));

        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found with id " + roomId));

        if(!room.isAvailable()) {
            throw new RuntimeException("Room is not available");
        }
        room.setAvailable(false);
        reservation.setRoom(room);
        reservation.setCustomer(customer);

        return reservationRepository.save(reservation);
    }

    public Reservation updateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }


    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
