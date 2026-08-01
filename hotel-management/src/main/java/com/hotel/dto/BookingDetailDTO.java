package com.hotel.dto;

public class BookingDetailDTO {

    private Long id;
    private Integer quantity;
    private Long bookingId;
    private Long hotelServiceId;

    public BookingDetailDTO() {
    }

    public BookingDetailDTO(Long id, Integer quantity, Long bookingId, Long hotelServiceId) {
        this.id = id;
        this.quantity = quantity;
        this.bookingId = bookingId;
        this.hotelServiceId = hotelServiceId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Long getHotelServiceId() {
        return hotelServiceId;
    }

    public void setHotelServiceId(Long hotelServiceId) {
        this.hotelServiceId = hotelServiceId;
    }
}