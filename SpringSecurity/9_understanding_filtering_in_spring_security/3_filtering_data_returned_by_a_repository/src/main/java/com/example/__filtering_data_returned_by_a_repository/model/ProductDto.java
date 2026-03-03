package com.example.__filtering_data_returned_by_a_repository.model;

import com.example.__filtering_data_returned_by_a_repository.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDto {

    private String name;
    private String owner;

    public ProductDto(String name, String owner) {
        this.name = name;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}
