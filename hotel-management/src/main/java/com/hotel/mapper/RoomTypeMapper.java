package com.hotel.mapper;

import com.hotel.dto.RoomTypeDTO;
import com.hotel.entity.RoomType;

public class RoomTypeMapper {

    public static RoomTypeDTO toDTO(RoomType roomType) {

        if (roomType == null) {
            return null;
        }

        return RoomTypeDTO.builder()
                .id(roomType.getId())
                .typeName(roomType.getTypeName())
                .price(roomType.getPrice())
                .capacity(roomType.getCapacity())
                .description(roomType.getDescription())
                .build();
    }

    public static RoomType toEntity(RoomTypeDTO dto) {

        if (dto == null) {
            return null;
        }

        return RoomType.builder()
                .id(dto.getId())
                .typeName(dto.getTypeName())
                .price(dto.getPrice())
                .capacity(dto.getCapacity())
                .description(dto.getDescription())
                .build();
    }
}