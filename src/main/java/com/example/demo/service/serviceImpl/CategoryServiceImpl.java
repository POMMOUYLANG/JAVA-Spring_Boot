package com.example.demo.service.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Product_category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        super();
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product_category saveCategory(Product_category drink_category) {
        if(!drink_category.isEmpty()){
            return categoryRepository.save(drink_category);
        }
        else{
            return null;
        }
    }

    @Override
    public List<Product_category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Product_category getCateforyById(Integer id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public List<Product_category> getFoodCategories() {
        return categoryRepository.findByType("food");
    }

    @Override
    public List<Product_category> getDrinkCategories() {
        return categoryRepository.findByType("drink");
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }
    
}
