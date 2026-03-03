package com.example.__filtering_return_value_of_a_method_using_post_filtering.service;


import com.example.__filtering_return_value_of_a_method_using_post_filtering.model.Product;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @PostFilter("filterObject.owner==authentication.name")
    public List<Product> findProducts(){
        List<Product> products = new ArrayList<>();
        products.add(new Product("Vinegar","Julien"));
        products.add(new Product("Apple Cider","Nicolai"));
        products.add(new Product("Vodka","Nicolai"));

        return products;
    }
}
