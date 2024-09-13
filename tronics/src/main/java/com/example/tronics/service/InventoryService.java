package com.example.tronics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tronics.model.Inventory;
import com.example.tronics.repository.InventoryRepo;

import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepo inventoryRepository;

    public Inventory createInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    public Optional<Inventory> getInventory(Long id) {
        return inventoryRepository.findById(id);
    }

    public Inventory updateInventory(Long id, Inventory inventory) {
        if (inventoryRepository.existsById(id)) {
            inventory.setId(id);
            return inventoryRepository.save(inventory);
        }
        throw new RuntimeException("Inventory not found");
    }

    public void deleteInventory(Long id) {
        if (inventoryRepository.existsById(id)) {
            inventoryRepository.deleteById(id);
        } else {
            throw new RuntimeException("Inventory not found");
        }
    }

    public boolean updateStock(Long productId, int quantity) throws Exception {
        Inventory inventory = inventoryRepository.findByProductId(productId)
            .orElseThrow(() -> new Exception("Product not found in inventory"));

        int newQuantity = inventory.getQuantity() - quantity;
        if (newQuantity < 0) {
            return false; // Indicate stock is insufficient
        }
        inventory.setQuantity(newQuantity);
        inventoryRepository.save(inventory);
        return true; // Stock updated successfully
    }
}
