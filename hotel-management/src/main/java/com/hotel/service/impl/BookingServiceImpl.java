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
                .orElseThrow(() ->
                        new RuntimeException("Không tìm thấy đặt phòng"));
    }


    @Override
    public Booking save(Booking booking) {
        return bookingRepository.save(booking);
    }


    @Override
    public Booking update(Long id, Booking booking) {

        Booking oldBooking = getById(id);

        oldBooking.setCheckInDate(booking.getCheckInDate());
        oldBooking.setCheckOutDate(booking.getCheckOutDate());
        oldBooking.setNumberOfGuests(booking.getNumberOfGuests());
        oldBooking.setStatus(booking.getStatus());
        oldBooking.setCustomer(booking.getCustomer());
        oldBooking.setRoom(booking.getRoom());

        return bookingRepository.save(oldBooking);
    }


    @Override
    public void delete(Long id) {
        bookingRepository.deleteById(id);
    }
}