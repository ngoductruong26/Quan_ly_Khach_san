package com.hotel.service.impl;

import com.hotel.entity.Room;
import com.hotel.repository.RoomRepository;
import com.hotel.service.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

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
                .orElseThrow(() -> new RuntimeException("Không tìm thấy phòng"));
    }

    @Override
    public Room save(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Room update(Long id, Room room) {

        Room old = getById(id);

        old.setRoomNumber(room.getRoomNumber());
        old.setFloor(room.getFloor());
        old.setStatus(room.getStatus());
        old.setRoomType(room.getRoomType());

        return roomRepository.save(old);
    }

    @Override
    public void delete(Long id) {
        roomRepository.delete(getById(id));
    }
}