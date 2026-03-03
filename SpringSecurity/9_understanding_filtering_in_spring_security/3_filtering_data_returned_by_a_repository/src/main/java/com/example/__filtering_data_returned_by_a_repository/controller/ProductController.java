package com.example.__filtering_data_returned_by_a_repository.controller;

import com.example.__filtering_data_returned_by_a_repository.model.ProductDto;
import com.example.__filtering_data_returned_by_a_repository.service.ProductService;
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
    public List<ProductDto> getProduct(){
        return productService.findProducts();
    }
}
