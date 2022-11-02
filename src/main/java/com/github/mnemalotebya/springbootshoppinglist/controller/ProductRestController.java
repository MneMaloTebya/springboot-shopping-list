package com.github.mnemalotebya.springbootshoppinglist.controller;

import com.github.mnemalotebya.springbootshoppinglist.model.entity.Product;
import com.github.mnemalotebya.springbootshoppinglist.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        Iterable<Product> iterable = productService.getAllProducts();
        for (Product product : iterable) {
            products.add(product);
        }
        return products;
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProductById(@PathVariable int id) {
        productService.deleteProductById(id);
    }

    @DeleteMapping("/products")
    public void deleteAllProducts() {
        productService.deleteAllProducts();
    }

    @PutMapping("/products")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }
}
