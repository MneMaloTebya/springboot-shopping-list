package com.github.mnemalotebya.springbootshoppinglist.model;

import com.github.mnemalotebya.springbootshoppinglist.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
