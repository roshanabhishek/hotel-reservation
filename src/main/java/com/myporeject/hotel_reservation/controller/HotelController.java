package com.myporeject.hotel_reservation.controller;

import com.myporeject.hotel_reservation.entity.Hotel;
import com.myporeject.hotel_reservation.service.HotelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @GetMapping
    public ResponseEntity<Page<Hotel>> getAllHotels( @RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "10") int size) {
        Page<Hotel> hotelPage = hotelService.getPaginatedHotels(page, size);
        return ResponseEntity.ok(hotelPage);
    }

    @GetMapping("/{id}")
    public Hotel getHotelById(@PathVariable Long id) {
        return hotelService.getHotelById(id);
    }

    @PostMapping
    public ResponseEntity<Object> createHotel(@Valid @RequestBody Hotel hotel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // If validation errors exist, return a bad request response with error messages
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }

        Hotel createdHotel = hotelService.saveHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHotel);
    }

    @PutMapping("/{id}")
    public Hotel updateHotel(@PathVariable Long id, @RequestBody Hotel hotel) {
        hotel.setId(id);
        return hotelService.saveHotel(hotel);
    }

    @DeleteMapping("/{id}")
    public void deleteHotel(@PathVariable Long id) {
        hotelService.deleteHotel(id);
    }
}
