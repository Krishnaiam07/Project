/*
 * package com.example.tronics.model;
 * 
 * import java.math.BigDecimal; import java.time.LocalDateTime;
 * 
 * import org.hibernate.annotations.CreationTimestamp; import
 * org.hibernate.annotations.UpdateTimestamp;
 * 
 * import jakarta.persistence.Column; import jakarta.persistence.Entity; import
 * jakarta.persistence.GeneratedValue; import
 * jakarta.persistence.GenerationType; import jakarta.persistence.Id; import
 * jakarta.persistence.Table;
 * 
 * @Entity
 * 
 * @Table(name = "product") public class Product {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
 * 
 * @Column(nullable = false) private String name;
 * 
 * @Column(nullable = false) private BigDecimal price;
 * 
 * @CreationTimestamp
 * 
 * @Column(name = "created_at", updatable = false) private LocalDateTime
 * createdAt;
 * 
 * @UpdateTimestamp
 * 
 * @Column(name = "updated_at") private LocalDateTime updatedAt;
 * 
 * // Constructors public Product() { }
 * 
 * public Product(String name, BigDecimal price) { this.name = name; this.price
 * = price; }
 * 
 * // Getters and Setters public Long getId() { return id; }
 * 
 * public void setId(Long id) { this.id = id; }
 * 
 * public String getName() { return name; }
 * 
 * public void setName(String name) { this.name = name; }
 * 
 * public BigDecimal getPrice() { return price; }
 * 
 * public void setPrice(BigDecimal price) { this.price = price; }
 * 
 * public LocalDateTime getCreatedAt() { return createdAt; }
 * 
 * public LocalDateTime getUpdatedAt() { return updatedAt; } }
 */