package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.ui.Model;

import com.example.demo.info.OrderInfo;
import com.example.demo.model.Current_product_order;
import com.example.demo.model.Product;
import com.example.demo.model.Product_category;
import com.example.demo.service.AddonsService;
import com.example.demo.service.CategoryService;
import com.example.demo.service.CurrentProductOrderService;
import com.example.demo.service.InvoiceService;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductSizeService;

@Controller
public class ProductController {
    private ProductService productService;
    private CategoryService categoryService;
    private AddonsService addonsService;
    private ProductSizeService productSizeService;
    private CurrentProductOrderService currentProductOrderService;
    private InvoiceService invoiceService;

    public ProductController(ProductService productService, CategoryService categoryService, AddonsService addonsService, ProductSizeService productSizeService, CurrentProductOrderService currentProductOrderService, InvoiceService invoiceService) {
        super();
        this.productService = productService;
        this.categoryService = categoryService;
        this.addonsService = addonsService;
        this.productSizeService = productSizeService;
        this.currentProductOrderService = currentProductOrderService;
        this.invoiceService = invoiceService;
    }

    @GetMapping("/admin/product_management/add_new_product")
    public String addNewProductForm(Model model){
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("drink", new Product());
        return "addNewDrink";
    }

    @PostMapping("/product_management/add_new_product/save")
    public String saveProduct(@ModelAttribute("drink") Product drink, @RequestParam("file") MultipartFile file){
        Product product = productService.saveProduct(drink, file);
        String type = categoryService.getCateforyById(product.getCategory_id()).getType();
        return "redirect:/admin/product_management/" + type;
    }

    @GetMapping("/user/product_selection")
    public String showDrinks(Model model){
        Current_product_order newOrder = new Current_product_order();
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("drinks", productService.getAllProducts());
        model.addAttribute("sugars", addonsService.getSugar());
        model.addAttribute("cream", addonsService.getCream());
        model.addAttribute("sizes", productSizeService.getAllProductSizes());
        model.addAttribute("order", newOrder);
        List<OrderInfo>orderInfos = new ArrayList<OrderInfo>();
        for (Current_product_order order : currentProductOrderService.getAllOrders()){
            orderInfos.add(new OrderInfo(productService.getProductById(order.getProduct_id()), productSizeService.getSizeById(order.getSize_id()), currentProductOrderService.getOrderById(order.getId())));
        }
        model.addAttribute("allOrders", orderInfos);
        return "drinkSelection";
    }

    @GetMapping("/admin/product_management/drink")
    public String listDrink (Model model) {
        model.addAttribute("drinks", productService.getAllDrinks());
        model.addAttribute("invoices", invoiceService.getAllInvoices());
        return "drinkManagement";
    }

    @GetMapping("/admin/product_management/food")
    public String listFood (Model model) {
        model.addAttribute("drinks", productService.getAllFoods());
        model.addAttribute("invoices", invoiceService.getAllInvoices());
        return "foodManagement";
    }

    

    @GetMapping("/admin/product_management/edit/{id}")
    public String editDrink(@PathVariable Integer id, Model model){
        Product updateDrink = productService.getProductById(id);
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("drink", updateDrink);
        return "editDrink";
    }

    @PostMapping("/product_management/edit/save/{id}")
    public String updateDrink (@PathVariable Integer id, @ModelAttribute("drink") Product updatedDrink, Model model, @RequestParam("file") MultipartFile file){
        Product drink = productService.getProductById(id);
        drink.setId(id);
        drink.setCode(updatedDrink.getCode());
        drink.setName(updatedDrink.getName());
        drink.setCategory_id(updatedDrink.getCategory_id());
        drink.setPrice(updatedDrink.getPrice());
        drink.setNote(updatedDrink.getNote());
        Product product = productService.updateProduct(drink, file);
        String type = categoryService.getCateforyById(product.getCategory_id()).getType();
        return "redirect:/admin/product_management/" + type;
    }

    @GetMapping("/product_management/delete/{id}")
    public String deleteDrink (@PathVariable Integer id) {
        Integer productCategoryId = productService.getProductById(id).getCategory_id();
        String type = categoryService.getCateforyById(productCategoryId).getType();
        productService.deleteProduct(id);
        
        return "redirect:/admin/product_management/" + type;
    }

    @GetMapping("/admin/product_management/drink/{id}")
    public String showDrink(@PathVariable Integer id, Model model){
        Product selectDrink = productService.getProductById(id);
        Product_category category = categoryService.getCateforyById(selectDrink.getCategory_id());
        model.addAttribute("drinks", productService.getAllDrinks());
        model.addAttribute("selectedCategory", category);
        model.addAttribute("selectedDrink", selectDrink);
        model.addAttribute("invoices", invoiceService.getAllInvoices());
        return "viewDrink";
    }

    @GetMapping("/admin/product_management/food/{id}")
    public String showFood(@PathVariable Integer id, Model model){
        Product selectDrink = productService.getProductById(id);
        Product_category category = categoryService.getCateforyById(selectDrink.getCategory_id());
        model.addAttribute("drinks", productService.getAllFoods());
        model.addAttribute("selectedCategory", category);
        model.addAttribute("selectedDrink", selectDrink);
        model.addAttribute("invoices", invoiceService.getAllInvoices());
        return "viewFood";
    }


}
