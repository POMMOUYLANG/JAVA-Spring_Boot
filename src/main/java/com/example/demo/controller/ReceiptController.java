package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.info.OrderInfo;
import com.example.demo.model.Current_product_order;
import com.example.demo.model.Receipt;
import com.example.demo.service.CurrentProductOrderService;
import com.example.demo.service.InvoiceService;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductSizeService;
import com.example.demo.service.ReceiptService;


@Controller
public class ReceiptController {
    private ReceiptService receiptService;
    private InvoiceService invoiceService;
    private CurrentProductOrderService currentProductOrderService;
    private ProductService productService;
    private ProductSizeService productSizeService;

    public ReceiptController(ReceiptService receiptService, InvoiceService invoiceService, CurrentProductOrderService currentProductOrderService, ProductService productService, ProductSizeService productSizeService) {
        super();
        this.receiptService = receiptService;
        this.invoiceService = invoiceService;
        this.currentProductOrderService = currentProductOrderService;
        this.productService = productService;
        this.productSizeService = productSizeService;
    }

    @PostMapping("/receipt/save")
    public String saveReceipt(@ModelAttribute("receipt") Receipt receipt){
        receiptService.saveReceipt(receipt);
        String destination = "redirect:/user/receipt/" + receipt.getId();
        return destination;
    }

    @GetMapping("/user/receipt/{id}")
    public String printReceipt(@PathVariable Integer id, Model model){
        Receipt receipt = receiptService.getReceiptById(id);
        model.addAttribute("receipt", receipt);
        model.addAttribute("invoice", invoiceService.getInvoiceById(receipt.getInvoice_id()));
        
        List<OrderInfo>orderInfos = new ArrayList<OrderInfo>();
        for (Current_product_order order : currentProductOrderService.getAllOrders()){
            orderInfos.add(new OrderInfo(productService.getProductById(order.getProduct_id()), productSizeService.getSizeById(order.getSize_id()), currentProductOrderService.getOrderById(order.getId())));
        }
        model.addAttribute("allOrders", orderInfos);

        return "PrintReceipt";
    }

}
