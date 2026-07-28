package com.hotel.service.impl;

import com.hotel.entity.BookingDetail;
import com.hotel.repository.BookingDetailRepository;
import com.hotel.service.BookingDetailService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingDetailServiceImpl implements BookingDetailService {


    private final BookingDetailRepository bookingServiceRepository;


    public BookingDetailServiceImpl(
            BookingDetailRepository bookingServiceRepository) {

        this.bookingServiceRepository = bookingServiceRepository;
    }


    @Override
    public List<BookingDetail> getAll() {
        return bookingServiceRepository.findAll();
    }


    @Override
    public BookingDetail getById(Long id) {

        return bookingServiceRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Không tìm thấy chi tiết đặt phòng"));
    }


    @Override
    public BookingDetail save(BookingDetail bookingService) {

        return bookingServiceRepository.save(bookingService);
    }


    @Override
    public BookingDetail update(Long id, BookingDetail bookingService) {

        BookingDetail oldBookingService = getById(id);

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