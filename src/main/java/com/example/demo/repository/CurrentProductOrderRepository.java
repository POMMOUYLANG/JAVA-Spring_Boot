package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Current_product_order;

public interface CurrentProductOrderRepository extends JpaRepository<Current_product_order, Integer> {
    
}
