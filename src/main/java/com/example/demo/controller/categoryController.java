package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.demo.model.Product;
import com.example.demo.model.Product_category;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class categoryController {
    private CategoryService categoryService;
    private ProductService productService;

    public categoryController(CategoryService categoryService, ProductService productService) {
        super();
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @GetMapping("/admin/product_management/add_new_category")
    public String createCategory(Model model){
        Product_category newCategory = new Product_category();
        model.addAttribute("category", newCategory);
        return "AddCategories";
    }

    @PostMapping("/product_management/save_new_category")
    public String saveCategory(@RequestParam("code") String code, @RequestParam("name") String name, @RequestParam("type") String type){
        Product_category category = new Product_category();
        category.setName(name);
        category.setCode(code);
        category.setType(type);
        categoryService.saveCategory(category);
        return "redirect:/admin/product_management/drink";
    }

    @PostMapping("/product_management/save_new_category_from_product")
    public String saveCategoryFromProduct(@RequestParam("code") String code, @RequestParam("name") String name, @RequestParam("type") String type, HttpServletRequest request){
        Product_category category = new Product_category();
        category.setName(name);
        category.setCode(code);
        category.setType(type);
        categoryService.saveCategory(category);
        String referer = request.getHeader("Referer");
        
        if (referer != null && !referer.isEmpty()) {
            return "redirect:" + referer;
        }
        return "redirect:/admin/product_management/add_new_product";
    }

    @GetMapping("/admin/category_management")
    public String viewCategory(Model model){
        model.addAttribute("categories", categoryService.getAllCategories());
        return "categoryManagement";
    }

    @GetMapping("/admin/delete_category/{id}")
    public String deleteCategory(@PathVariable Integer id){
        for(Product product: productService.getAllProducts()){
            if(product.getCategory_id() ==  id) {
                productService.deleteProduct(product.getId());
            }
        }
        categoryService.deleteCategory(id);
        return "redirect:/admin/category_management";
    }
}
