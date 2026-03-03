package com.example.__filtering_data_returned_by_a_repository.service;

import com.example.__filtering_data_returned_by_a_repository.entity.Product;
import com.example.__filtering_data_returned_by_a_repository.model.ProductDto;
import com.example.__filtering_data_returned_by_a_repository.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

//    public void saveProducts(){
//        productRepository.save(new Product(null,"Apple","Julien"));
//        productRepository.save(new Product(null,"Banana","Nicolai"));
//        productRepository.save(new Product(null,"Pineapple","Julien"));
//    }
    public List<ProductDto> findProducts(){

        List<Product> products = productRepository.findAll();
        return products.stream().map(product -> {
            return new ProductDto(product.getName(),product.getOwner());
        }).toList();
    }
}
