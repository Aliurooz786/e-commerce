package com.urooz.ecommerce.service.impl;

import com.urooz.ecommerce.model.Cart;
import com.urooz.ecommerce.model.CartItem;
import com.urooz.ecommerce.repository.CartRepository;
import com.urooz.ecommerce.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart getCartByUserId(String userId) {
        log.info("Fetching cart for userId: {}", userId);
        return cartRepository.findByUserId(userId).orElse(
                Cart.builder()
                        .userId(userId)
                        .items(new ArrayList<>())
                        .createdAt(new Date())
                        .updatedAt(new Date())
                        .build()
        );
    }

    @Override
    public Cart addItemToCart(String userId, CartItem item) {
        log.info("Adding item to cart. userId: {}, item: {}", userId, item);
        Cart cart = getCartByUserId(userId);

        boolean updated = false;
        for (CartItem ci : cart.getItems()) {
            if (ci.getProductId().equals(item.getProductId())) {
                ci.setQuantity(ci.getQuantity() + item.getQuantity());
                updated = true;
                log.info("Item already in cart, updated quantity. ProductId: {}, new quantity: {}", item.getProductId(), ci.getQuantity());
                break;
            }
        }

        if (!updated) {
            cart.getItems().add(item);
            log.info("New item added to cart: {}", item.getProductId());
        }

        cart.setUpdatedAt(new Date());
        return cartRepository.save(cart);
    }

    @Override
    public Cart updateCartItem(String userId, CartItem item) {
        log.info("Updating cart item. userId: {}, item: {}", userId, item);
        Cart cart = getCartByUserId(userId);

        for (CartItem ci : cart.getItems()) {
            if (ci.getProductId().equals(item.getProductId())) {
                ci.setQuantity(item.getQuantity());
                log.info("Updated quantity for productId: {}, new quantity: {}", item.getProductId(), item.getQuantity());
                break;
            }
        }

        cart.setUpdatedAt(new Date());
        return cartRepository.save(cart);
    }

    @Override
    public Cart removeItemFromCart(String userId, String productId) {
        log.info("Removing item from cart. userId: {}, productId: {}", userId, productId);
        Cart cart = getCartByUserId(userId);

        boolean removed = cart.getItems().removeIf(ci -> ci.getProductId().equals(productId));
        if (removed) {
            log.info("Item removed successfully. productId: {}", productId);
        } else {
            log.warn("Item not found in cart. productId: {}", productId);
        }

        cart.setUpdatedAt(new Date());
        return cartRepository.save(cart);
    }

    @Override
    public void clearCart(String userId) {
        log.info("Clearing cart for userId: {}", userId);
        cartRepository.findByUserId(userId).ifPresent(cart -> {
            cartRepository.delete(cart);
            log.info("Cart cleared for userId: {}", userId);
        });
    }
}