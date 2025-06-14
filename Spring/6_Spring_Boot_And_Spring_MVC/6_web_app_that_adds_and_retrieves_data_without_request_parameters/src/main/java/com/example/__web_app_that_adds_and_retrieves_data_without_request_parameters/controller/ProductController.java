package com.example.__web_app_that_adds_and_retrieves_data_without_request_parameters.controller;

import com.example.__web_app_that_adds_and_retrieves_data_without_request_parameters.service.ProductService;
import  com.example.__web_app_that_adds_and_retrieves_data_without_request_parameters.model.Product;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;

@Controller
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/products")
    public String getView(Model model){
        List<Product> list = productService.getProductList();
        model.addAttribute("list",list);
        return "products.html";
    }

    @PostMapping("/products")
    public String addProducts(Product product,Model model){
        productService.addProduct(product);
        model.addAttribute("list",productService.getProductList());
        return "products.html";
    }
}
