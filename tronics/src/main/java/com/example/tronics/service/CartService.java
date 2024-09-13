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

    public Cart addItemToCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public Optional<Cart> getCartItem(Long id) {
        return cartRepository.findById(id);
    }

    public Cart updateCartItem(Long id, Cart cart) {
        if (cartRepository.existsById(id)) {
            cart.setId(id);
            return cartRepository.save(cart);
        }
        return null;
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
