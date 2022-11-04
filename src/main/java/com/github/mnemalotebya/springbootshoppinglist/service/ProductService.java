package com.github.mnemalotebya.springbootshoppinglist.service;

import com.github.mnemalotebya.springbootshoppinglist.model.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProductByTaskId(int id);
    Product addProduct(Product product);
    List<Product> getAllProducts();
    void deleteProductById(int id);
    void deleteAllProduct();
}
