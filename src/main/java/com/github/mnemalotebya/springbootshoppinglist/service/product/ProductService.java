package com.github.mnemalotebya.springbootshoppinglist.service.product;

import com.github.mnemalotebya.springbootshoppinglist.model.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAllByTaskId(int id);
    void save(Product product);
    void delete(int id);
    void deleteAll();
}
