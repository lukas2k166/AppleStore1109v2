package com.example.demo.controller;

import com.example.demo.entities.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add/new/product")
//    @GetMapping("/add/new/product")
    public void addNewProduct(){
        productService.addNewProduct();
    }

    @GetMapping("/get/all/products")
    public List<Product> getAllProducts(){
       return productService.getAllProducts();
    }

}
