package com.example.demo.repository;

import com.example.demo.model.Product;
import lombok.Getter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
public class ProductRepository {
    private  List<Product> products = new ArrayList<>();
    public ProductRepository() {
        products.add(new Product(1, "Product 1", 100.0));
        products.add(new Product(2, "Product 2", 200.0));
        products.add(new Product(3, "Product 3", 300.0));
    }
}
