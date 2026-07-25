package com.hotel.service;

import com.hotel.entity.Booking;

import java.util.List;

public interface BookingService {

    List<Booking> getAll();

    Booking getById(Long id);

    Booking save(Booking booking);

    Booking update(Long id, Booking booking);

    void delete(Long id);
}