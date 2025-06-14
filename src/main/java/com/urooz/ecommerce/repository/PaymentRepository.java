package com.urooz.ecommerce.repository;

import com.urooz.ecommerce.model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment, String> {
}