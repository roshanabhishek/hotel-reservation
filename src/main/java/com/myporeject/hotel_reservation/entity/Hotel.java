package com.myporeject.hotel_reservation.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"email", "address"})})
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    @JsonProperty("email")
    private String email;

    @NotBlank(message = "Hotel Name is mandatory")
    @JsonProperty("name")
    private String name;

    @NotBlank(message = "Hotel Address is mandatory")
    @JsonProperty("address")
    private String address;

    @NotNull(message = "Latitude is mandatory")
    @JsonProperty("latitude")
    private Double latitude;

    @NotNull(message = "Longitude is mandatory")
    @JsonProperty("longitude")
    private Double longitude;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private Set<Room> rooms;

    // Getters and Setters
    public void setId(Long id) {
        this.id = id;
    }
}
