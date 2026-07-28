package com.hotel.mapper;

import com.hotel.dto.PaymentDTO;
import com.hotel.entity.Payment;

public class PaymentMapper {

    public static PaymentDTO toDTO(Payment payment) {

        if (payment == null) {
            return null;
        }

        PaymentDTO dto = new PaymentDTO();

        dto.setId(payment.getId());
        dto.setAmount(payment.getAmount());
        dto.setPaymentMethod(payment.getPaymentMethod());
        dto.setPaymentDate(payment.getPaymentDate());
        dto.setPaymentStatus(payment.getPaymentStatus());

        if (payment.getBooking() != null) {
            dto.setBookingId(payment.getBooking().getId());
        }

        return dto;
    }

    public static Payment toEntity(PaymentDTO dto) {

        if (dto == null) {
            return null;
        }

        Payment payment = new Payment();

        payment.setId(dto.getId());
        payment.setAmount(dto.getAmount());
        payment.setPaymentMethod(dto.getPaymentMethod());
        payment.setPaymentDate(dto.getPaymentDate());
        payment.setPaymentStatus(dto.getPaymentStatus());

        // booking sẽ được gán trong Service

        return payment;
    }
}