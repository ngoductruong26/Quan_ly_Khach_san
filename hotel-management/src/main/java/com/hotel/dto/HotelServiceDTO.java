package com.hotel.dto;

import java.math.BigDecimal;

public class HotelServiceDTO {

    private Long id;
    private String serviceName;
    private BigDecimal price;
    private String description;

    public HotelServiceDTO() {
    }

    public HotelServiceDTO(Long id, String serviceName, BigDecimal price, String description) {
        this.id = id;
        this.serviceName = serviceName;
        this.price = price;
        this.description = description;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}