package com.hotel.service.impl;

import com.hotel.entity.Room;
import com.hotel.repository.RoomRepository;
import com.hotel.service.RoomService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl extends RoomService {

    private final RoomRepository roomRepository;


    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }


    @Override
    public List<Room> getAll() {
        return roomRepository.findAll();
    }


    @Override
    public Room getById(Long id) {
        return roomRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Không tìm thấy phòng"));
    }


    @Override
    public Room save(Room room) {
        return roomRepository.save(room);
    }


    @Override
    public Room update(Long id, Room room) {

        Room oldRoom = getById(id);

        oldRoom.setRoomNumber(room.getRoomNumber());
        oldRoom.setFloor(room.getFloor());
        oldRoom.setStatus(room.getStatus());
        oldRoom.setRoomType(room.getRoomType());

        return roomRepository.save(oldRoom);
    }


    @Override
    public void delete(Long id) {
        roomRepository.deleteById(id);
    }
}