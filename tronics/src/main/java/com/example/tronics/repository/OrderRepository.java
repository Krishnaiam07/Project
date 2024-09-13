package com.example.tronics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.tronics.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // Custom queries can be added here if needed
}
