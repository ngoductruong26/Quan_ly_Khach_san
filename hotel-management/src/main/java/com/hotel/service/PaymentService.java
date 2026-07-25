package com.hotel.service;

import com.hotel.entity.Payment;

import java.util.List;

public interface PaymentService {

    List<Payment> getAll();

    Payment getById(Long id);

    Payment save(Payment payment);

    Payment update(Long id, Payment payment);

    void delete(Long id);
}