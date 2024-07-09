package com.myporeject.hotel_reservation.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Room type is mandatory")
    private RoomType type;

    @NotNull(message = "Price is mandatory")
    private double price;

    private boolean isAvailable;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private Set<Reservation> reservations;

    // Getters and Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    public Long getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public RoomType getType() {
        return type;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
