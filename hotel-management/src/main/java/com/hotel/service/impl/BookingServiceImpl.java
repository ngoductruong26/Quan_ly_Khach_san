package com.hotel.service.impl;

import com.hotel.entity.Booking;
import com.hotel.repository.BookingRepository;
import com.hotel.service.BookingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public List<Booking> getAll() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy đơn đặt phòng"));
    }

    @Override
    public Booking save(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Booking update(Long id, Booking booking) {

        Booking old = getById(id);

        old.setCustomer(booking.getCustomer());
        old.setRoom(booking.getRoom());
        old.setCheckInDate(booking.getCheckInDate());
        old.setCheckOutDate(booking.getCheckOutDate());
        old.setStatus(booking.getStatus());

        return bookingRepository.save(old);
    }

    @Override
    public void delete(Long id) {
        bookingRepository.delete(getById(id));
    }
}