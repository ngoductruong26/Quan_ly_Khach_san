package com.hotel.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomTypeDTO {

    private Long id;

    private String typeName;

    private Double price;

    private Integer capacity;

    private String description;

}