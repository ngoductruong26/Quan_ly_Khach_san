package com.hotel.repository;

import com.hotel.entity.BookingService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingServiceRepository extends JpaRepository<BookingService, Long> {

}