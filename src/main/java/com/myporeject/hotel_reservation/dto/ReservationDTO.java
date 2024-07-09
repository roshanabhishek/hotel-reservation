package com.myporeject.hotel_reservation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.myporeject.hotel_reservation.util.CustomLocalDateDeserializer;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class ReservationDTO {
    private Long id;

    @NotNull(message = "CheckIn Date is mandatory")
    @JsonProperty("check_in")
    @JsonDeserialize(using = CustomLocalDateDeserializer.class)
    private LocalDate check_in;

    @NotNull(message = "Checkout Date is mandatory")
    @JsonProperty("check_out")
    @JsonDeserialize(using = CustomLocalDateDeserializer.class)
    private LocalDate check_out;

    @NotNull(message = "Room ID is mandatory")
    @JsonProperty("room_id")
    private Long roomId;

    @NotNull(message = "Customer ID is mandatory")
    @JsonProperty("customer_id")
    private Long customerId;

    // Getters and Setters

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCheckIn() {
        return check_in;
    }

    public LocalDate getCheckOut() {
        return check_out;
    }

    public Long getId() {
        return id;
    }

    public Long getRoomId() {
        return roomId;
    }

    public Long getCustomerId() {
        return customerId;
    }
}

