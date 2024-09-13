package com.example.tronics.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tronics.model.Order;
import com.example.tronics.model.OrderItem;
import com.example.tronics.model.OrderRequest;
import com.example.tronics.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private InventoryService inventoryService;

    @Transactional
    public Order placeOrder(OrderRequest orderRequest, Long userId) throws Exception {
        BigDecimal totalAmount = BigDecimal.ZERO;

        for (OrderItem item : orderRequest.getItems()) {
            // Update stock and handle concurrency
            boolean stockUpdated = inventoryService.updateStock(item.getProductId(), item.getQuantity());
            if (!stockUpdated) {
                throw new Exception("Insufficient stock for product id " + item.getProductId());
            }

            // Assuming total amount needs to be calculated based on the quantity
            // Here, you can either calculate total amount based on another service or hardcode
            BigDecimal productPrice = BigDecimal.valueOf(100); // Placeholder for price; replace with actual logic
            totalAmount = totalAmount.add(productPrice.multiply(BigDecimal.valueOf(item.getQuantity())));
        }

        // Create and save the order
        Order order = new Order();
        order.setUserId(userId);
        order.setTotalAmount(totalAmount);
        order.setStatus("PLACED");

        return orderRepository.save(order);
    }
}
