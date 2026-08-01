package com.hotel.dto;

public class RoomDTO {

    private Long id;
    private String roomNumber;
    private String floor;
    private String status;
    private Long roomTypeId;

    public RoomDTO() {
    }

    public RoomDTO(Long id, String roomNumber, String floor, String status, Long roomTypeId) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.floor = floor;
        this.status = status;
        this.roomTypeId = roomTypeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Long roomTypeId) {
        this.roomTypeId = roomTypeId;
    }
}