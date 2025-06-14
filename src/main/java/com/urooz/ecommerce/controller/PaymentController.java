package com.urooz.ecommerce.controller;

import com.urooz.ecommerce.dto.PaymentRequest;
import com.urooz.ecommerce.model.Payment;
import com.urooz.ecommerce.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public Payment makePayment(@RequestBody PaymentRequest request) {
        log.info("Received payment request: {}", request);
        return paymentService.makePayment(request);
    }

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable String id) {
        return paymentService.getPaymentById(id);
    }
}