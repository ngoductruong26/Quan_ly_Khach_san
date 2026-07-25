package com.hotel.service.impl;

import com.hotel.entity.HotelService;
import com.hotel.repository.HotelServiceRepository;
import com.hotel.service.HotelServiceService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceServiceImpl implements HotelServiceService {


    private final HotelServiceRepository hotelServiceRepository;


    public HotelServiceServiceImpl(
            HotelServiceRepository hotelServiceRepository) {

        this.hotelServiceRepository = hotelServiceRepository;
    }


    @Override
    public List<HotelService> getAll() {
        return hotelServiceRepository.findAll();
    }


    @Override
    public HotelService getById(Long id) {

        return hotelServiceRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Không tìm thấy dịch vụ"));
    }


    @Override
    public HotelService save(HotelService hotelService) {
        return hotelServiceRepository.save(hotelService);
    }


    @Override
    public HotelService update(Long id, HotelService hotelService) {

        HotelService oldService = getById(id);

        oldService.setServiceName(hotelService.getServiceName());
        oldService.setPrice(hotelService.getPrice());

        return hotelServiceRepository.save(oldService);
    }


    @Override
    public void delete(Long id) {
        hotelServiceRepository.deleteById(id);
    }
}