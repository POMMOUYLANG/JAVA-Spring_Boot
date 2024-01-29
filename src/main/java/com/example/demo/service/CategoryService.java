package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Product_category;

public interface CategoryService {
    Product_category saveCategory(Product_category drink_category);
    List<Product_category> getAllCategories();
    Product_category getCateforyById(Integer id);
    List<Product_category> getFoodCategories();
    List<Product_category> getDrinkCategories();
    void deleteCategory(Integer id);
}
