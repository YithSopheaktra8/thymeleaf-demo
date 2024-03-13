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
    public String getProductById(Model model,@PathVariable("id") Integer id) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "product";
    }
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id) {
        productService.deleteProductById(id);
        return "delete";
    }

    @GetMapping("/update/{id}")
    public String updateProduct(@PathVariable("id") Integer id, Model model) {
        Product foundProduct = productService.findAll().stream()
                .filter(product -> product.getId().equals(id)).findFirst().orElse(null);
        System.out.println(foundProduct.toString());
        model.addAttribute("product", foundProduct);
        return "update";
    }
    @PostMapping("/update")
    public String updateProduct(@ModelAttribute("product") Product product) {
        System.out.println(product.toString());
        productService.updateProduct(product);
        return "redirect:/";
    }

    @GetMapping("/create")
    public String create(Model model) {
        Product product = new Product();
        model.addAttribute("product",product);
        return "create";
    }
    @PostMapping("/create")
    public String submit(@ModelAttribute("product") Product product) {
        productService.addProduct(product);
        return "redirect:/";
    }

}
