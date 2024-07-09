package com.myporeject.hotel_reservation.controller;

import com.myporeject.hotel_reservation.entity.Room;
import com.myporeject.hotel_reservation.dto.RoomDTO;
import com.myporeject.hotel_reservation.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable Long id) {
        return roomService.getRoomById(id);
    }

    @PostMapping
    public ResponseEntity<Object> createRoom(@Valid @RequestBody RoomDTO createRoomRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // If validation errors exist, return a bad request response with error messages
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }

        Room tempRoom = new Room();
        tempRoom.setPrice(createRoomRequest.getPrice());
        tempRoom.setType(createRoomRequest.getType());
        tempRoom.setAvailable(true);
        Room createdRoom =  roomService.createRoom(createRoomRequest.getHotelId(), tempRoom);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRoom);
    }

    @PutMapping("/{id}")
    public Room updateRoom(@PathVariable Long id, @RequestBody Room room) {
        room.setId(id);
        return roomService.saveRoom(room);
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
    }
}
