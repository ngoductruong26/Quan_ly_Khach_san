package com.hotel.service.impl;

import com.hotel.entity.Booking;
import com.hotel.entity.Customer;
import com.hotel.entity.Room;
import com.hotel.repository.BookingRepository;
import com.hotel.repository.CustomerRepository;
import com.hotel.repository.RoomRepository;
import com.hotel.service.BookingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final CustomerRepository customerRepository;
    private final RoomRepository roomRepository;

    public BookingServiceImpl(BookingRepository bookingRepository,
                              CustomerRepository customerRepository,
                              RoomRepository roomRepository) {
        this.bookingRepository = bookingRepository;
        this.customerRepository = customerRepository;
        this.roomRepository = roomRepository;
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
        linkRelations(booking);
        return bookingRepository.save(booking);
    }

    @Override
    public Booking update(Long id, Booking booking) {
        Booking old = getById(id);
        linkRelations(booking);

        old.setCustomer(booking.getCustomer());
        old.setRoom(booking.getRoom());
        old.setCheckInDate(booking.getCheckInDate());
        old.setCheckOutDate(booking.getCheckOutDate());
        old.setNumberOfGuests(booking.getNumberOfGuests());
        old.setStatus(booking.getStatus());

        return bookingRepository.save(old);
    }

    private void linkRelations(Booking booking) {
        if (booking.getCustomer() != null && booking.getCustomer().getId() != null) {
            Customer c = customerRepository.findById(booking.getCustomer().getId()).orElse(null);
            booking.setCustomer(c);
        }
        if (booking.getRoom() != null && booking.getRoom().getId() != null) {
            Room r = roomRepository.findById(booking.getRoom().getId()).orElse(null);
            booking.setRoom(r);
        }
    }

    @Override
    public void delete(Long id) {
        bookingRepository.delete(getById(id));
    }
}