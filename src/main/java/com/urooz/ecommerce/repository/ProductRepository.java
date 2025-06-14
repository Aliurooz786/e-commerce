package com.urooz.ecommerce.repository;

import com.urooz.ecommerce.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, String> {
    Optional<Product> findByProductCode(String productCode);
    boolean existsByProductCode(String productCode);
}