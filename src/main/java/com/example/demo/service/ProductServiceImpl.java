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
        return productRepository.getProducts()
                .stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void addProduct(Product product) {
        productRepository.getProducts().add(product);
    }

    @Override
    public void deleteProductById(Integer id) {
        productRepository.getProducts()
                .removeIf(product -> product.getId().equals(id));
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.getProducts()
                .stream()
                .filter(p -> p.getId().equals(product.getId()))
                .forEach(p -> {
                    p.setName(product.getName());
                    p.setPrice(product.getPrice());
                });
    }
}
