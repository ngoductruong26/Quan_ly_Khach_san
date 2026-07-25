package com.hotel.service;

import com.hotel.entity.RoomType;

import java.util.List;

public interface RoomTypeService {

    List<RoomType> getAll();

    RoomType getById(Long id);

    RoomType save(RoomType roomType);

    RoomType update(Long id, RoomType roomType);

    void delete(Long id);
}