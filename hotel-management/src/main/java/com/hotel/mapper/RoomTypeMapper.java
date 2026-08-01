package com.hotel.mapper;

import com.hotel.dto.RoomTypeDTO;
import com.hotel.entity.RoomType;

public class RoomTypeMapper {

    public static RoomTypeDTO toDTO(RoomType roomType) {
        if (roomType == null) {
            return null;
        }

        RoomTypeDTO dto = new RoomTypeDTO();
        dto.setId(roomType.getId());
        dto.setTypeName(roomType.getTypeName());
        dto.setPrice(roomType.getPrice());
        dto.setCapacity(roomType.getCapacity());
        dto.setDescription(roomType.getDescription());

        return dto;
    }

    public static RoomType toEntity(RoomTypeDTO dto) {
        if (dto == null) {
            return null;
        }

        RoomType roomType = new RoomType();
        roomType.setId(dto.getId());
        roomType.setTypeName(dto.getTypeName());
        roomType.setPrice(dto.getPrice());
        roomType.setCapacity(dto.getCapacity());
        roomType.setDescription(dto.getDescription());

        return roomType;
    }
}