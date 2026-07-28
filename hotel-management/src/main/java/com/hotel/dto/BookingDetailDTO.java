package com.hotel.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingDetailDTO {

    private Long id;

    private Integer quantity;

    private Long bookingId;

    private Long hotelServiceId;
}