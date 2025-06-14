package com.urooz.ecommerce.service;

import com.urooz.ecommerce.dto.OrderRequest;
import com.urooz.ecommerce.model.Order;

import java.util.List;

public interface OrderService {
    Order placeOrder(OrderRequest request);
    List<Order> getAllOrders();
    Order getOrderById(String orderId);
    List<Order> getOrdersByUserId(String userId);
    void deleteOrder(String orderId);
}
