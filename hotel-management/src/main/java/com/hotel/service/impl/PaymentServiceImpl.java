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
                .orElseThrow(() ->
                        new RuntimeException("Không tìm thấy thanh toán"));
    }


    @Override
    public Payment save(Payment payment) {

        return paymentRepository.save(payment);
    }


    @Override
    public Payment update(Long id, Payment payment) {

        Payment oldPayment = getById(id);

        oldPayment.setAmount(payment.getAmount());
        oldPayment.setPaymentMethod(payment.getPaymentMethod());
        oldPayment.setPaymentDate(payment.getPaymentDate());
        oldPayment.setPaymentStatus(payment.getPaymentStatus());
        oldPayment.setBooking(payment.getBooking());

        return paymentRepository.save(oldPayment);
    }


    @Override
    public void delete(Long id) {

        paymentRepository.deleteById(id);
    }
}