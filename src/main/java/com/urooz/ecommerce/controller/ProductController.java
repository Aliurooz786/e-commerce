package com.urooz.ecommerce.controller;

import com.urooz.ecommerce.dto.ProductRequest;
import com.urooz.ecommerce.model.Product;
import com.urooz.ecommerce.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Product addProduct(@RequestBody ProductRequest request) {
        log.info("Adding product: {}", request);
        return productService.addProduct(request);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable String id, @RequestBody ProductRequest request) {
        log.info("Updating product with ID: {}, Data: {}", id, request);
        return productService.updateProduct(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable String id) {
        log.info("Deleting product with ID: {}", id);
        productService.deleteProduct(id);
        return "Product deleted successfully";
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id) {
        log.info("Fetching product with ID: {}", id);
        return productService.getProductById(id);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        log.info("Fetching all products");
        return productService.getAllProducts();
    }
}