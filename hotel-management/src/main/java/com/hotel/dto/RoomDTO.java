package com.hotel.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomDTO {

    private Long id;

    private String roomNumber;

    private String floor;

    private String status;

    private Long roomTypeId;
}