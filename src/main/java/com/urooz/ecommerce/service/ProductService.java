package com.urooz.ecommerce.service;

import com.urooz.ecommerce.dto.ProductRequest;
import com.urooz.ecommerce.model.Product;

import java.util.List;

public interface ProductService {
    Product addProduct(ProductRequest request);
    Product updateProduct(String id, ProductRequest request);
    void deleteProduct(String id);
    Product getProductById(String id);
    List<Product> getAllProducts();
}