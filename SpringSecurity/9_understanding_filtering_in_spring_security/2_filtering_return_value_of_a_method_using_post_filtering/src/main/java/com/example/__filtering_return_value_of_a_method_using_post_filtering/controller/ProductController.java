package com.example.__filtering_return_value_of_a_method_using_post_filtering.controller;

import com.example.__filtering_return_value_of_a_method_using_post_filtering.model.Product;
import com.example.__filtering_return_value_of_a_method_using_post_filtering.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all/product")
    public List<Product> getProducts(){
        List<Product> products =  productService.findProducts();
        return products;
    }
}
