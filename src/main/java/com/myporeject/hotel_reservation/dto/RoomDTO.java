package com.myporeject.hotel_reservation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.myporeject.hotel_reservation.entity.RoomType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

public class RoomDTO {
    @Null(message = "ID must be null for creation")
    private Long id;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Room type is mandatory")
    @JsonProperty("type")
    private RoomType type;

    @Min(value = 1, message = "Price must be greater than 0")
    @JsonProperty("price")
    private double price;

    @NotNull(message = "Hotel ID is mandatory")
    @JsonProperty("hotel_id")
    private Long hotelId;

    @NotNull(message = "Room Number is mandatory")
    @JsonProperty("room_number")
    private String room_number;

    // Getters and Setters
    public double getPrice() {
        return price;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public RoomType getType() {
        return type;
    }

    public String getRoomNumber() { return room_number; }
}
