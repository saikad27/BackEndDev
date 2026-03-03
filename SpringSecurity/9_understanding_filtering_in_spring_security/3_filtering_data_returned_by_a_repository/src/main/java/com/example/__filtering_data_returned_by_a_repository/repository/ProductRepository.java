package com.example.__filtering_data_returned_by_a_repository.repository;

import com.example.__filtering_data_returned_by_a_repository.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.access.prepost.PostFilter;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product,Integer> {

    //Using @PostFilter annotation here is a bad practice, so we inject spEL inside the query
    @Query("SELECT p FROM Product p WHERE p.owner=?#{authentication.name}")
    @Override
    public List<Product> findAll();
}
