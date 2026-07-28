package com.hotel.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDTO {

    private Long id;

    private BigDecimal amount;

    private String paymentMethod;

    private LocalDate paymentDate;

    private String paymentStatus;

    private Long bookingId;
}