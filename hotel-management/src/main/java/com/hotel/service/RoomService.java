package com.hotel.service;

import com.hotel.entity.Room;
import java.util.List;

public interface RoomService {

    List<Room> getAll();

    Room getById(Long id);

    Room save(Room room);

    Room update(Long id, Room room);

    void delete(Long id);
}