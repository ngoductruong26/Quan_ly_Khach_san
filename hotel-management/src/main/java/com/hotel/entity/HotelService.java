package com.hotel.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "hotel_services")
public class HotelService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serviceName;

    private BigDecimal price;

    @OneToMany(mappedBy = "hotelService")
    private List<BookingService> bookingServices;

    public HotelService() {
    }

    // Getter & Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<BookingService> getBookingServices() {
        return bookingServices;
    }

    public void setBookingServices(List<BookingService> bookingServices) {
        this.bookingServices = bookingServices;
    }
}