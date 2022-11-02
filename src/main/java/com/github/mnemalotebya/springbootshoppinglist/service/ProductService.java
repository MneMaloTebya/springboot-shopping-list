package com.github.mnemalotebya.springbootshoppinglist.service;

import com.github.mnemalotebya.springbootshoppinglist.model.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(int id);
    Product addProduct(Product product);
    void deleteProductById(int id);
    void deleteAllProducts();
    Product updateProduct(Product product);
}
