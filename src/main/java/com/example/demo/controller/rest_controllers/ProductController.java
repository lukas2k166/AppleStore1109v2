package com.example.demo.controller.rest_controllers;

import com.example.demo.entities.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/get/all/products")
    public List<Product> getAllProducts(){
       return productService.getAllProducts();
    }

    @GetMapping("/add/category/{name}")
    public void addCategory(@PathVariable(value = "name") String name){
        productService.addCategory(name);
    }
}
