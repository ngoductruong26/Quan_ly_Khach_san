package com.hotel.mapper;

import com.hotel.dto.BookingDetailDTO;
import com.hotel.entity.BookingDetail;

public class BookingDetailMapper {

    public static BookingDetailDTO toDTO(BookingDetail detail) {

        if (detail == null) {
            return null;
        }

        BookingDetailDTO dto = new BookingDetailDTO();

        dto.setId(detail.getId());
        dto.setQuantity(detail.getQuantity());

        if (detail.getBooking() != null) {
            dto.setBookingId(detail.getBooking().getId());
        }

        if (detail.getHotelService() != null) {
            dto.setHotelServiceId(detail.getHotelService().getId());
        }

        return dto;
    }

    public static BookingDetail toEntity(BookingDetailDTO dto) {

        if (dto == null) {
            return null;
        }

        BookingDetail detail = new BookingDetail();

        detail.setId(dto.getId());
        detail.setQuantity(dto.getQuantity());

        return detail;
    }
}