package com.urooz.ecommerce.service;

import com.urooz.ecommerce.dto.PaymentRequest;
import com.urooz.ecommerce.model.Payment;

import java.util.List;

public interface PaymentService {
    Payment makePayment(PaymentRequest request);
    List<Payment> getAllPayments();
    Payment getPaymentById(String id);
}