package com.hotel.controller;

import com.hotel.entity.BookingDetail;
import com.hotel.service.BookingDetailService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/booking-services")
@CrossOrigin(origins = "*")
public class BookingDetailController {

    private final BookingDetailService bookingDetailService;

    public BookingDetailController(BookingDetailService bookingDetailService) {
        this.bookingDetailService = bookingDetailService;
    }

    @GetMapping
    public List<BookingDetail> getAll() {
        return bookingDetailService.getAll();
    }

    @GetMapping("/{id}")
    public BookingDetail getById(@PathVariable Long id) {
        return bookingDetailService.getById(id);
    }

    @PostMapping
    public BookingDetail create(@RequestBody BookingDetail bookingDetail) {
        return bookingDetailService.save(bookingDetail);
    }

    @PutMapping("/{id}")
    public BookingDetail update(@PathVariable Long id,
                                @RequestBody BookingDetail bookingDetail) {
        return bookingDetailService.update(id, bookingDetail);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookingDetailService.delete(id);
    }
}