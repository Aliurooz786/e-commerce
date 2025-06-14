package com.urooz.ecommerce.service;

import com.urooz.ecommerce.model.Cart;
import com.urooz.ecommerce.model.CartItem;

import java.util.List;

public interface CartService {
    Cart getCartByUserId(String userId);
    Cart addItemToCart(String userId, CartItem item);
    Cart updateCartItem(String userId, CartItem item);
    Cart removeItemFromCart(String userId, String productId);
    void clearCart(String userId);
}