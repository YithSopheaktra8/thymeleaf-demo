package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.getProducts();
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }

    @Override
    public void deleteProductById(Integer id) {
        productRepository.deleteProductById(id);
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.updateProduct(product);
    }
}
