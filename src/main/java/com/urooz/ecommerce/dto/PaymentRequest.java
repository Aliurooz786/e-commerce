package com.urooz.ecommerce.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentRequest {
    private String orderId;
    private Double amount;
    private String method;
}