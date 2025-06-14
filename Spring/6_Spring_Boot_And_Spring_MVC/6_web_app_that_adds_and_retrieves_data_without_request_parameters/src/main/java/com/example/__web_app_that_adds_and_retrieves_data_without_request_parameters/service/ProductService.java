package com.example.__web_app_that_adds_and_retrieves_data_without_request_parameters.service;

import com.example.__web_app_that_adds_and_retrieves_data_without_request_parameters.model.Product;

import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final List<Product> productList;

    ProductService() {
        productList = new ArrayList<Product>();
    }

    public void addProduct(Product product){
        productList.add(product);
    }

    public List<Product> getProductList(){
        return productList;
    }

}
