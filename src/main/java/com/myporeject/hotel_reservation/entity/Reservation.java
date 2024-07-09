package com.myporeject.hotel_reservation.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate checkIn;
    private LocalDate checkOut;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // Getters and Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Long getId() {
        return id;
    }

    public Room getRoom() {
        return room;
    }
}
