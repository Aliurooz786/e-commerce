package com.urooz.ecommerce.controller;

import com.urooz.ecommerce.model.Cart;
import com.urooz.ecommerce.model.CartItem;
import com.urooz.ecommerce.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@Slf4j
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/{userId}")
    public Cart getCart(@PathVariable String userId) {
        log.info("Fetching cart for userId: {}", userId);
        return cartService.getCartByUserId(userId);
    }

    @PostMapping("/{userId}/add")
    public Cart addItem(@PathVariable String userId, @RequestBody CartItem item) {
        log.info("Adding item to cart. userId: {}, item: {}", userId, item);
        return cartService.addItemToCart(userId, item);
    }

    @PutMapping("/{userId}/update")
    public Cart updateItem(@PathVariable String userId, @RequestBody CartItem item) {
        log.info("Updating item in cart. userId: {}, item: {}", userId, item);
        return cartService.updateCartItem(userId, item);
    }

    @DeleteMapping("/{userId}/remove/{productId}")
    public Cart removeItem(@PathVariable String userId, @PathVariable String productId) {
        log.info("Removing item from cart. userId: {}, productId: {}", userId, productId);
        return cartService.removeItemFromCart(userId, productId);
    }

    @DeleteMapping("/{userId}/clear")
    public void clearCart(@PathVariable String userId) {
        log.info("Clearing entire cart for userId: {}", userId);
        cartService.clearCart(userId);
    }
}