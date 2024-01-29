package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Product_size;

public interface ProductSizeService {
    Boolean isEmpty();
    Product_size saveProduct_size(Product_size product_size);
    List<Product_size> getAllProductSizes();
    Product_size getSizeById(Integer id);
}
