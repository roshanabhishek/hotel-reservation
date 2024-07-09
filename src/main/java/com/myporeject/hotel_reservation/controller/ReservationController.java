package com.myporeject.hotel_reservation.controller;

import com.myporeject.hotel_reservation.dto.ReservationDTO;
import com.myporeject.hotel_reservation.entity.Reservation;
import com.myporeject.hotel_reservation.service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable Long id) {
        return reservationService.getReservationById(id);
    }

    @PostMapping
    public ResponseEntity<Object> createReservation(@Valid @RequestBody ReservationDTO reservationDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // If validation errors exist, return a bad request response with error messages
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }

        Reservation tempReservation = new Reservation();
        tempReservation.setCheckIn(reservationDTO.getCheckIn());
        tempReservation.setCheckOut(reservationDTO.getCheckOut());

        Reservation createdReservation =  reservationService.createReservation(reservationDTO.getCustomerId(), reservationDTO.getRoomId(),tempReservation);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdReservation);
    }

    @PutMapping("/{id}")
    public Reservation updateReservation(@PathVariable Long id, @RequestBody Reservation reservation) {
        reservation.setId(id);
        return reservationService.updateReservation(reservation);
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
    }
}
