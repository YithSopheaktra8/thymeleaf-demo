package com.example.demo.service;

import com.example.demo.model.Product;

import java.util.List;

public interface ProductService {
    public List<Product> findAll();
    public Product findById(Integer id);
    public void addProduct(Product product);
    public void deleteProductById(Integer id);
    public void updateProduct(Product product);
}
