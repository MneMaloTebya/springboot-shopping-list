package com.github.mnemalotebya.springbootshoppinglist.controller;

import com.github.mnemalotebya.springbootshoppinglist.model.entity.Product;
import com.github.mnemalotebya.springbootshoppinglist.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/id")
    public String getAllProduct(Model model, @PathVariable("id") int id) {
        model.addAttribute("products", productService.findAllByTaskId(id));
        return "products";
    }

    @PostMapping
    public String addProduct(Product product) {
        productService.save(product);
        return "redirect:/products";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        productService.delete(id);
        return "redirect:/products";
    }

    @DeleteMapping
    public String deleteAll() {
        productService.deleteAll();
        return "redirect:/products";
    }
}
