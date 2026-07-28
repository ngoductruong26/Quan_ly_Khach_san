package com.hotel.mapper;

import com.hotel.dto.HotelServiceDTO;
import com.hotel.entity.HotelService;

public class HotelServiceMapper {

    public static HotelServiceDTO toDTO(HotelService service) {

        if (service == null) {
            return null;
        }

        return HotelServiceDTO.builder()
                .id(service.getId())
                .serviceName(service.getServiceName())
                .price(service.getPrice())
                .description(service.getDescription())
                .build();
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