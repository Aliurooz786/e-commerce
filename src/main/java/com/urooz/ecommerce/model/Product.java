package com.urooz.ecommerce.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "products")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    private String id;

    @Indexed(unique = true)
    private String productCode;

    private String name;
    private String description;
    private Double price;
    private String brand;
    private String category;
    private String gender;
    private int quantity;

    private Date createdAt;
    private Date updatedAt;
}