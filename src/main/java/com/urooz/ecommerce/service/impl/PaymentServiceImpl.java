package com.urooz.ecommerce.service.impl;

import com.urooz.ecommerce.dto.PaymentRequest;
import com.urooz.ecommerce.model.Payment;
import com.urooz.ecommerce.repository.PaymentRepository;
import com.urooz.ecommerce.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment makePayment(PaymentRequest request) {
        String transactionId = UUID.randomUUID().toString();
        Payment payment = Payment.builder()
                .orderId(request.getOrderId())
                .amount(request.getAmount())
                .method(request.getMethod())
                .status("SUCCESS") // mock success
                .transactionId(transactionId)
                .createdAt(new Date())
                .build();

        log.info("Processing mock payment for Order ID: {}", request.getOrderId());
        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> getAllPayments() {
        log.info("Fetching all payment records");
        return paymentRepository.findAll();
    }

    @Override
    public Payment getPaymentById(String id) {
        log.info("Fetching payment by ID: {}", id);
        return paymentRepository.findById(id).orElse(null);
    }
}