package com.example.tronics.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.tronics.model.Cart;
import com.example.tronics.service.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping
    public ResponseEntity<String> addItemToCart(@RequestBody Cart cart) {
        String result = cartService.addItemToCart(cart);
        if (result.equals("Product not found")) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCartItem(@PathVariable Long id) {
        Optional<Cart> cart = cartService.getCartItem(id);
        return cart.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCartItem(@PathVariable Long id, @RequestBody Cart cart) {
        String result = cartService.updateCartItem(id, cart);
        if (result.equals("Product not found") || result.equals("Cart item not found")) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
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
