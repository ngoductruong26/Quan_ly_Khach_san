package com.hotel.dto;

public class RoomTypeDTO {

    private Long id;
    private String typeName;
    private Double price;
    private Integer capacity;
    private String description;

    public RoomTypeDTO() {
    }

    public RoomTypeDTO(Long id, String typeName, Double price, Integer capacity, String description) {
        this.id = id;
        this.typeName = typeName;
        this.price = price;
        this.capacity = capacity;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}