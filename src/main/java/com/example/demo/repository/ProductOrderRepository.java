package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Product_order;

public interface ProductOrderRepository extends JpaRepository<Product_order, Integer> {
    
}
