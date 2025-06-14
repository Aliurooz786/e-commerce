package com.urooz.ecommerce.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {
    private String userId;
    private List<String> productIds;
    private double totalAmount;
    private String status;
}
