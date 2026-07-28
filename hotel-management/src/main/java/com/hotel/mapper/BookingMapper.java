package com.hotel.mapper;

import com.hotel.dto.BookingDTO;
import com.hotel.entity.Booking;

public class BookingMapper {

    public static BookingDTO toDTO(Booking booking) {

        if (booking == null) {
            return null;
        }

        BookingDTO dto = BookingDTO.builder()
                .id(booking.getId())
                .checkInDate(booking.getCheckInDate())
                .checkOutDate(booking.getCheckOutDate())
                .numberOfGuests(booking.getNumberOfGuests())
                .status(booking.getStatus())
                .build();

        if (booking.getCustomer() != null) {
            dto.setCustomerId(booking.getCustomer().getId());
        }

        if (booking.getRoom() != null) {
            dto.setRoomId(booking.getRoom().getId());
        }

        return dto;
    }

    public static Booking toEntity(BookingDTO dto) {

        if (dto == null) {
            return null;
        }

        Booking booking = new Booking();

        booking.setId(dto.getId());
        booking.setCheckInDate(dto.getCheckInDate());
        booking.setCheckOutDate(dto.getCheckOutDate());
        booking.setNumberOfGuests(dto.getNumberOfGuests());
        booking.setStatus(dto.getStatus());

        // customer và room sẽ được gán trong Service

        return booking;
    }
}