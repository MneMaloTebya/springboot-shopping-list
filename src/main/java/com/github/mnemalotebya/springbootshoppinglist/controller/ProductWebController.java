package com.github.mnemalotebya.springbootshoppinglist.controller;

import com.github.mnemalotebya.springbootshoppinglist.model.entity.Product;
import com.github.mnemalotebya.springbootshoppinglist.service.ProductService;
import com.github.mnemalotebya.springbootshoppinglist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductWebController {

    @Autowired
    private ProductService productService;

    @Autowired
    private TaskService taskService;

    @GetMapping("/productList")
    public String productList(Model model) {
        List<Product> products = new ArrayList<>();
        Iterable<Product> iterable = productService.getAllProducts();
        for (Product product : iterable) {
            products.add(product);
        }
        model.addAttribute("products", products);
        return "productList";
    }

    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProductById(@PathVariable int id) {
        productService.deleteProductById(id);
        return "redirect:/productList";
    }

    @DeleteMapping("/deleteAllProduct")
    public String deleteAllProduct() {
        productService.deleteAllProduct();
        return "redirect:/productList";
    }

    @GetMapping("/addProduct")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String saveProduct(@ModelAttribute("newProduct") Product product) {
        // TODO: 04.11.2022 При доавлении продукта, я должен так-же его сохранять в Таске. Это даст мне взаимосвязь между таской и продуктом

        List<Product> products = new ArrayList<>();
        String name = product.getName();
        int count = product.getCount();
        float weight = product.getWeight();
        boolean conditionFromName = (name != null && name.length() > 0);
        boolean conditionFromCount = (count >= 0);
        boolean conditionFromWeight = (weight >= 0.0);
        if (conditionFromWeight && conditionFromCount && conditionFromName) {
            Product newProduct = productService.addProduct(product);
            products.add(newProduct);
        }

        return "redirect:/productList";
    }
}
