package com.hotel.mapper;

import com.hotel.dto.HotelServiceDTO;
import com.hotel.entity.HotelService;

public class HotelServiceMapper {

    public static HotelServiceDTO toDTO(HotelService service) {
        if (service == null) {
            return null;
        }

        HotelServiceDTO dto = new HotelServiceDTO();
        dto.setId(service.getId());
        dto.setServiceName(service.getServiceName());
        dto.setPrice(service.getPrice());
        dto.setDescription(service.getDescription());

        return dto;
    }

    public static HotelService toEntity(HotelServiceDTO dto) {
        if (dto == null) {
            return null;
        }

        HotelService service = new HotelService();
        service.setId(dto.getId());
        service.setServiceName(dto.getServiceName());
        service.setPrice(dto.getPrice());
        service.setDescription(dto.getDescription());

        return service;
    }
}