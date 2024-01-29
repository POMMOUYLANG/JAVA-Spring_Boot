package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Product_size;

public interface ProductSizeRepository extends JpaRepository<Product_size, Integer> {
    
}
