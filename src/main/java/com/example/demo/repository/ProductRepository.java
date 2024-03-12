package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> products = new ArrayList<>();

    public ProductRepository() {
        products.add(new Product(1, "Product 1", 100.0));
        products.add(new Product(2, "Product 2", 200.0));
        products.add(new Product(3, "Product 3", 300.0));
    }

    public List<Product> getProducts() {
        return products;
    }
    public void addProduct(Product product) {
        products.add(product);
    }
     public void deleteProductById(Integer id) {
        products.removeIf(p -> p.getId().equals(id));
    }
    public Product findById(Integer id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    public void updateProduct(Product product) {
        products.stream()
                .filter(p -> p.getId().equals(product.getId()))
                .findFirst()
                .ifPresent(p -> {
                    p.setName(product.getName());
                    p.setPrice(product.getPrice());
                });
    }
}
