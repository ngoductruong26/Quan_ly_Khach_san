package com.hotel.controller;

import com.hotel.entity.RoomType;
import com.hotel.service.RoomTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room-types")
public class RoomTypeController {

    private final RoomTypeService roomTypeService;

    public RoomTypeController(RoomTypeService roomTypeService) {
        this.roomTypeService = roomTypeService;
    }

    @GetMapping
    public List<RoomType> getAll() {
        return roomTypeService.getAll();
    }

    @GetMapping("/{id}")
    public RoomType getById(@PathVariable Long id) {
        return roomTypeService.getById(id);
    }

    @PostMapping
    public RoomType save(@RequestBody RoomType roomType) {
        return roomTypeService.save(roomType);
    }

    @PutMapping("/{id}")
    public RoomType update(@PathVariable Long id,
                           @RequestBody RoomType roomType) {
        return roomTypeService.update(id, roomType);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        roomTypeService.delete(id);
    }
}