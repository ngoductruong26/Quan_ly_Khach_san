package com.hotel.service;

import com.hotel.entity.BookingService;

import java.util.List;

public interface BookingDetailService {

    List<BookingService> getAll();

    BookingService getById(Long id);

    BookingService save(BookingService bookingService);

    BookingService update(Long id, BookingService bookingService);

    void delete(Long id);
}