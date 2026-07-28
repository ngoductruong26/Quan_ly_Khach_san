package com.hotel.service;

import com.hotel.entity.BookingDetail;

import java.util.List;

public interface BookingDetailService {

    List<BookingDetail> getAll();

    BookingDetail getById(Long id);

    BookingDetail save(BookingDetail bookingService);

    BookingDetail update(Long id, BookingDetail bookingService);

    void delete(Long id);
}