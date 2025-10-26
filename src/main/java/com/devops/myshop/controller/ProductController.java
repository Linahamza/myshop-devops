package com.devops.myshop.controller;

import com.devops.myshop.model.Product;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ProductController {

    private List<Product> products = new ArrayList<>();

    // Initialisation avec des données de test
    public ProductController() {
        products.add(new Product(1L, "Laptop Dell XPS 15", 1299.99, "Electronics"));
        products.add(new Product(2L, "iPhone 15 Pro", 999.99, "Electronics"));
        products.add(new Product(3L, "Nike Air Max", 129.99, "Fashion"));
        products.add(new Product(4L, "Samsung 4K TV", 799.99, "Electronics"));
        products.add(new Product(5L, "Coffee Machine", 199.99, "Home"));
    }

    @GetMapping("/")
    public String home() {
        return "Welcome to MyShop API! Use /api/products to get all products.";
    }

    @GetMapping("/products") // ← Endpoint 1
    public List<Product> getAllProducts() {
        return products;
    }

    @GetMapping("/products/{id}")// ← Endpoint 2
    public Product getProductById(@PathVariable Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @GetMapping("/products/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category) {
        return products.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "{\"status\":\"UP\",\"service\":\"MyShop API\"}";
    }
}