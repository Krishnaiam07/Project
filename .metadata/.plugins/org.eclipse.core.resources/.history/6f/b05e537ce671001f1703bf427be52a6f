package com.example.tronics.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tronics.model.Cart;
import com.example.tronics.service.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping
    public Cart addItemToCart(@RequestBody Cart cart) {
        return cartService.addItemToCart(cart);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCartItem(@PathVariable Long id) {
        Optional<Cart> cart = cartService.getCartItem(id);
        return cart.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cart> updateCartItem(@PathVariable Long id, @RequestBody Cart cart) {
        Cart updatedCart = cartService.updateCartItem(id, cart);
        return updatedCart != null ? ResponseEntity.ok(updatedCart) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeCartItem(@PathVariable Long id) {
        cartService.removeCartItem(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Cart>> getUserCartItems(@PathVariable Long userId) {
        List<Cart> cartItems = cartService.getUserCartItems(userId);
        return ResponseEntity.ok(cartItems);
    }
}
