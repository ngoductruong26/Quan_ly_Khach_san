package com.hotel.mapper;

import com.hotel.dto.RoomDTO;
import com.hotel.entity.Room;

public class RoomMapper {

    public static RoomDTO toDTO(Room room) {

        if (room == null) {
            return null;
        }

        RoomDTO dto = new RoomDTO();

        dto.setId(room.getId());
        dto.setRoomNumber(room.getRoomNumber());
        dto.setFloor(room.getFloor());
        dto.setStatus(room.getStatus());

        if (room.getRoomType() != null) {
            dto.setRoomTypeId(room.getRoomType().getId());
        }

        return dto;
    }

    public static Room toEntity(RoomDTO dto) {

        if (dto == null) {
            return null;
        }

        Room room = new Room();

        room.setId(dto.getId());
        room.setRoomNumber(dto.getRoomNumber());
        room.setFloor(dto.getFloor());
        room.setStatus(dto.getStatus());

        // roomType sẽ được gán trong Service khi lấy từ DB
        return room;
    }
}