package com.urooz.ecommerce.dto;

import lombok.Data;

@Data
public class ProductRequest {
    private String productCode;
    private String name;
    private String description;
    private Double price;
    private String brand;
    private String category;
    private String gender;
    private int quantity;
}