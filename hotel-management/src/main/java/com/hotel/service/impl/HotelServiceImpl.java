package com.hotel.service.impl;

import com.hotel.entity.HotelService;
import com.hotel.repository.HotelServiceRepository;
import com.hotel.service.HotelServiceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelServiceService {

    private final HotelServiceRepository hotelServiceRepository;

    public HotelServiceImpl(HotelServiceRepository hotelServiceRepository) {
        this.hotelServiceRepository = hotelServiceRepository;
    }

    @Override
    public List<HotelService> getAll() {
        return hotelServiceRepository.findAll();
    }

    @Override
    public HotelService getById(Long id) {
        return hotelServiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy dịch vụ"));
    }

    @Override
    public HotelService save(HotelService service) {
        return hotelServiceRepository.save(service);
    }

    @Override
    public HotelService update(Long id, HotelService service) {

        HotelService old = getById(id);

        old.setServiceName(service.getServiceName());
        old.setPrice(service.getPrice());
        old.setDescription(service.getDescription());

        return hotelServiceRepository.save(old);
    }

    @Override
    public void delete(Long id) {
        hotelServiceRepository.delete(getById(id));
    }
}