package com.hotel.service.impl;

import com.hotel.entity.BookingService;
import com.hotel.repository.BookingServiceRepository;
import com.hotel.service.BookingDetailService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingDetailServiceImpl implements BookingDetailService {


    private final BookingServiceRepository bookingServiceRepository;


    public BookingDetailServiceImpl(
            BookingServiceRepository bookingServiceRepository) {

        this.bookingServiceRepository = bookingServiceRepository;
    }


    @Override
    public List<BookingService> getAll() {
        return bookingServiceRepository.findAll();
    }


    @Override
    public BookingService getById(Long id) {

        return bookingServiceRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Không tìm thấy chi tiết đặt phòng"));
    }


    @Override
    public BookingService save(BookingService bookingService) {

        return bookingServiceRepository.save(bookingService);
    }


    @Override
    public BookingService update(Long id, BookingService bookingService) {

        BookingService oldBookingService = getById(id);

        oldBookingService.setQuantity(
                bookingService.getQuantity()
        );

        oldBookingService.setBooking(
                bookingService.getBooking()
        );

        oldBookingService.setHotelService(
                bookingService.getHotelService()
        );


        return bookingServiceRepository.save(oldBookingService);
    }


    @Override
    public void delete(Long id) {

        bookingServiceRepository.deleteById(id);
    }
}