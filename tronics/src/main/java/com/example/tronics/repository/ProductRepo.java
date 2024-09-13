package com.example.tronics.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tronics.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {
    
    // Method to find products by name with pagination
    Page<Product> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
