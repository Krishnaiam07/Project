package com.example.tronics.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tronics.model.Cart;
import com.example.tronics.repository.CartRepository;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductService productService; // Inject ProductService

    public String addItemToCart(Cart cart) {
        // Check if the product exists
        if (!productService.getProduct(cart.getProductId()).isPresent()) {
            return "Product not found";
        }
        cartRepository.save(cart);
        return "Item added to cart successfully";
    }

    public Optional<Cart> getCartItem(Long id) {
        return cartRepository.findById(id);
    }

    public String updateCartItem(Long id, Cart cart) {
        if (!cartRepository.existsById(id)) {
            return "Cart item not found";
        }
        // Check if the product exists
        if (!productService.getProduct(cart.getProductId()).isPresent()) {
            return "Product not found";
        }
        cart.setId(id);
        cartRepository.save(cart);
        return "Cart item updated successfully";
    }

    public void removeCartItem(Long id) {
        cartRepository.deleteById(id);
    }

    public List<Cart> getUserCartItems(Long userId) {
        return cartRepository.findAll().stream()
            .filter(cart -> cart.getUserId().equals(userId))
            .collect(Collectors.toList());
    }
}
