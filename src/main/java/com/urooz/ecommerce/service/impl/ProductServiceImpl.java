package com.urooz.ecommerce.service.impl;

import com.urooz.ecommerce.dto.ProductRequest;
import com.urooz.ecommerce.model.Product;
import com.urooz.ecommerce.repository.ProductRepository;
import com.urooz.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProduct(ProductRequest request) {
        if (productRepository.existsByProductCode(request.getProductCode())) {
            return null; // or throw exception later
        }

        Product product = Product.builder()
                .productCode(request.getProductCode())
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .brand(request.getBrand())
                .category(request.getCategory())
                .gender(request.getGender())
                .quantity(request.getQuantity())
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();

        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(String id, ProductRequest request) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setName(request.getName());
            product.setDescription(request.getDescription());
            product.setPrice(request.getPrice());
            product.setBrand(request.getBrand());
            product.setCategory(request.getCategory());
            product.setGender(request.getGender());
            product.setQuantity(request.getQuantity());
            product.setUpdatedAt(new Date());
            return productRepository.save(product);
        }

        return null;
    }

    @Override
    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product getProductById(String id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}