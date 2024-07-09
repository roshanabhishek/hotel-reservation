package com.myporeject.hotel_reservation.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"email", "phoneNumber"})})
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First Name is mandatory")
    @JsonProperty("first_name")
    private String firstName;

    @NotBlank(message = "Last Name is mandatory")
    @JsonProperty("last_name")
    private String lastName;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    @JsonProperty("email")
    private String email;

    @NotBlank(message = "Phonenumber is mandatory")
    @JsonProperty("phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Reservation> reservations;

    // Getters and Setters

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String name) {
        this.lastName = name;
    }

    public String getLastName() {
        return lastName;
    }

    @JsonProperty("full_name")
    public String getFullName() {
        return firstName + " " + lastName;
    }
}
