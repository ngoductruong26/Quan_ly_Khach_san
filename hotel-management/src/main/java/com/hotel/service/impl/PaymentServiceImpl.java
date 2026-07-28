package com.hotel.service.impl;

import com.hotel.entity.Payment;
import com.hotel.repository.PaymentRepository;
import com.hotel.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getById(Long id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy thanh toán"));
    }

    @Override
    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment update(Long id, Payment payment) {

        Payment old = getById(id);

        old.setBooking(payment.getBooking());
        old.setAmount(payment.getAmount());
        old.setPaymentMethod(payment.getPaymentMethod());
        old.setPaymentDate(payment.getPaymentDate());

        return paymentRepository.save(old);
    }

    @Override
    public void delete(Long id) {
        paymentRepository.delete(getById(id));
    }
}