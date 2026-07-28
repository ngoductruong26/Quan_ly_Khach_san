package com.hotel.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelServiceDTO {

    private Long id;

    private String serviceName;

    private BigDecimal price;

    private String description;
}