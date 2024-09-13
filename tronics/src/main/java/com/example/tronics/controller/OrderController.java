package com.example.tronics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tronics.model.OrderItem;
import com.example.tronics.model.OrderRequest;
import com.example.tronics.service.InventoryService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/placeOrder")
    public ResponseEntity<String> placeOrder(@RequestBody OrderRequest orderRequest) {
        try {
            for (OrderItem item : orderRequest.getItems()) {
                boolean isStockUpdated = inventoryService.updateStock(item.getProductId(), item.getQuantity());
                
                if (!isStockUpdated) {
                    // If stock is insufficient, return a message indicating the item is out of stock
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Item with product ID " + item.getProductId() + " is out of stock or insufficient quantity available.");
                }
            }
            return ResponseEntity.ok("Order placed successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
