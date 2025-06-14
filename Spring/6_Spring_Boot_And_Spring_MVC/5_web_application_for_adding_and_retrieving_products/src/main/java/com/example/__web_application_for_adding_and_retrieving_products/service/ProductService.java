package com.example.__web_application_for_adding_and_retrieving_products.service;

import com.example.__web_application_for_adding_and_retrieving_products.model.Product;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;


@Service
public class ProductService {
    private final List<Product> products = new ArrayList<Product>();

    public void addProduct(Product product){
        products.add(product);
    }

    public List<Product> getProducts(){
        return products;
    }
}
