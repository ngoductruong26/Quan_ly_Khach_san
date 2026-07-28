package com.hotel.controller;

import com.hotel.entity.HotelService;
import com.hotel.service.HotelServiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
@CrossOrigin(origins = "*")
public class HotelServiceController {

    private final HotelServiceService hotelServiceService;

    public HotelServiceController(HotelServiceService hotelServiceService) {
        this.hotelServiceService = hotelServiceService;
    }

    @GetMapping
    public List<HotelService> getAll() {
        return hotelServiceService.getAll();
    }

    @GetMapping("/{id}")
    public HotelService getById(@PathVariable Long id) {
        return hotelServiceService.getById(id);
    }

    @PostMapping
    public HotelService create(@RequestBody HotelService service) {
        return hotelServiceService.save(service);
    }

    @PutMapping("/{id}")
    public HotelService update(@PathVariable Long id,
                               @RequestBody HotelService service) {
        return hotelServiceService.update(id, service);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        hotelServiceService.delete(id);
    }
}