package com.hotel.service.impl;

import com.hotel.entity.RoomType;
import com.hotel.repository.RoomTypeRepository;
import com.hotel.service.RoomTypeService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomTypeServiceImpl implements RoomTypeService {

    private final RoomTypeRepository roomTypeRepository;


    public RoomTypeServiceImpl(RoomTypeRepository roomTypeRepository) {
        this.roomTypeRepository = roomTypeRepository;
    }


    @Override
    public List<RoomType> getAll() {
        return roomTypeRepository.findAll();
    }


    @Override
    public RoomType getById(Long id) {
        return roomTypeRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Không tìm thấy loại phòng"));
    }


    @Override
    public RoomType save(RoomType roomType) {
        return roomTypeRepository.save(roomType);
    }


    @Override
    public RoomType update(Long id, RoomType roomType) {

        RoomType oldRoomType = getById(id);

        oldRoomType.setTypeName(roomType.getTypeName());
        oldRoomType.setDescription(roomType.getDescription());
        oldRoomType.setPricePerNight(roomType.getPricePerNight());
        oldRoomType.setMaxGuests(roomType.getMaxGuests());

        return roomTypeRepository.save(oldRoomType);
    }


    @Override
    public void delete(Long id) {
        roomTypeRepository.deleteById(id);
    }
}