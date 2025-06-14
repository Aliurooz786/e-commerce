package com.urooz.ecommerce.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "payments")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    private String id;
    private String orderId;
    private Double amount;
    private String method;      // e.g., UPI, CARD, COD
    private String status;      // PENDING, SUCCESS, FAILED
    private String transactionId;
    private Date createdAt;
}