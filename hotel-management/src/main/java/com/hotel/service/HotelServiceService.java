package com.hotel.service;

import com.hotel.entity.HotelService;

import java.util.List;

public interface HotelServiceService {

    List<HotelService> getAll();

    HotelService getById(Long id);

    HotelService save(HotelService hotelService);

    HotelService update(Long id, HotelService hotelService);

    void delete(Long id);
}