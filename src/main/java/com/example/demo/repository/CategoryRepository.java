package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Product_category;

public interface CategoryRepository extends JpaRepository <Product_category, Integer> {
    List<Product_category> findByType(String type);
}
