package com.myporeject.hotel_reservation.service;

import com.myporeject.hotel_reservation.entity.Hotel;
import com.myporeject.hotel_reservation.entity.Room;
import com.myporeject.hotel_reservation.exception.ResourceNotFoundException;
import com.myporeject.hotel_reservation.repository.HotelRepository;
import com.myporeject.hotel_reservation.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private HotelRepository hotelRepository;

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room getRoomById(Long id) {
        return roomRepository.findById(id).orElse(null);
    }

    public Room createRoom(Long hotelId, Room room) {
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with id " + hotelId));
        room.setHotel(hotel);
        return roomRepository.save(room);
    }

    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }
}
