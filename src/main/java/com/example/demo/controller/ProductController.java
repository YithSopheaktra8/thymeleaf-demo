package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller// This annotation is used to mark the class as a controller
//@RestController // This annotation is used to create RESTful web services using Spring MVC
public class ProductController {

    private final ProductService productService;

    @GetMapping("/")
    public String index(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("/product/{id}")
    public String getProductById(Model model,@PathVariable Integer id) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "product";
    }
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        productService.deleteProductById(id);
        return "delete";
    }

    @GetMapping("/update/{id}")
    public String updateProduct(@PathVariable Integer id) {
        Product product = new Product(id,"Hanuman", 3.0);
        productService.updateProduct(product);
        return "update";
    }

    @GetMapping("/create")
    public String addProduct(Model model) {
        Product product = Product.builder()
                .name("Hanuman")
                .price(3.0)
                .build();
        model.addAttribute("product",product);
        productService.addProduct(product);
        return "create";
    }
}
