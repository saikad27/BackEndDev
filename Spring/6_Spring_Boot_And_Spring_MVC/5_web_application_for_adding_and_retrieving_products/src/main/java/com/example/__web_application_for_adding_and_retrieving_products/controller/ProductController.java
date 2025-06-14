package com.example.__web_application_for_adding_and_retrieving_products.controller;


import java.util.List;
import com.example.__web_application_for_adding_and_retrieving_products.service.ProductService;
import com.example.__web_application_for_adding_and_retrieving_products.model.Product;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    private final ProductService productService;

    ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/products")
    public String viewProducts(Model model){
        List<Product> products = productService.getProducts();
        model.addAttribute("products",products);
        return "products.html";
    }

    @PostMapping("/products")
    public String addProduct(@RequestParam String name,@RequestParam float price, Model model){
        Product product = new Product(name,price);
        productService.addProduct(product);
        List<Product> products = productService.getProducts();
        model.addAttribute("products",products);
        return "products.html";
    }

}
