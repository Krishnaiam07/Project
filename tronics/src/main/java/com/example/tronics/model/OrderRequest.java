package com.example.tronics.model;

import java.util.List;

public class OrderRequest {
    private List<OrderItem> items;

    // Getters and Setters
    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}
