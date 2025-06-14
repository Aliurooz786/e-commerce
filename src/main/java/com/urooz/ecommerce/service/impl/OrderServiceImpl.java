package com.urooz.ecommerce.service.impl;

import com.urooz.ecommerce.dto.OrderRequest;
import com.urooz.ecommerce.model.Order;
import com.urooz.ecommerce.repository.OrderRepository;
import com.urooz.ecommerce.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order placeOrder(OrderRequest request) {
        log.info("Placing new order for userId: {}", request.getUserId());

        Order order = Order.builder()
                .userId(request.getUserId())
                .productIds(request.getProductIds())
                .totalAmount(request.getTotalAmount())
                .status(request.getStatus())
                .orderDate(new Date())
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();

        Order savedOrder = orderRepository.save(order);
        log.info("Order placed with ID: {}", savedOrder.getId());

        return savedOrder;
    }

    @Override
    public List<Order> getAllOrders() {
        log.info("Fetching all orders");
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(String orderId) {
        log.info("Fetching order by ID: {}", orderId);
        return orderRepository.findById(orderId).orElse(null);
    }

    @Override
    public List<Order> getOrdersByUserId(String userId) {
        log.info("Fetching orders by userId: {}", userId);
        return orderRepository.findByUserId(userId);
    }

    @Override
    public void deleteOrder(String orderId) {
        log.info("Deleting order with ID: {}", orderId);
        orderRepository.deleteById(orderId);
    }
}