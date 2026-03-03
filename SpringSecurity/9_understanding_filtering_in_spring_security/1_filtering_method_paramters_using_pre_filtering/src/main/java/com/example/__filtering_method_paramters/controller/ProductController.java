package com.example.__filtering_method_paramters.controller;

import com.example.__filtering_method_paramters.model.Product;
import com.example.__filtering_method_paramters.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/sell")
    public List<Product> products(){
        List<Product> products = new ArrayList<>();
        products.add(new Product("Wine","natalie"));
        products.add(new Product("Ramen","julian"));
        products.add(new Product("Cake","natalie"));
        return productService.sellProducts(products);
    }
}
