package com.urooz.ecommerce.controller;

import com.urooz.ecommerce.dto.OrderRequest;
import com.urooz.ecommerce.model.Order;
import com.urooz.ecommerce.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order placeOrder(@RequestBody OrderRequest request) {
        log.info("Received request to place order: {}", request);
        return orderService.placeOrder(request);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        log.info("GET /api/orders called to fetch all orders");
        return orderService.getAllOrders();
    }

    @GetMapping("/{orderId}")
    public Order getOrderById(@PathVariable String orderId) {
        log.info("GET /api/orders/{} called", orderId);
        return orderService.getOrderById(orderId);
    }

    @GetMapping("/user/{userId}")
    public List<Order> getOrdersByUserId(@PathVariable String userId) {
        log.info("GET /api/orders/user/{} called", userId);
        return orderService.getOrdersByUserId(userId);
    }

    @DeleteMapping("/{orderId}")
    public String deleteOrder(@PathVariable String orderId) {
        log.info("DELETE /api/orders/{} called", orderId);
        orderService.deleteOrder(orderId);
        return "Order deleted successfully";
    }
}