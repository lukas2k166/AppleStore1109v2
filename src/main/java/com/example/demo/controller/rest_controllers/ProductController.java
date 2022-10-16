package com.example.demo.controller.rest_controllers;

import com.example.demo.entities.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.service_implementations.ProductServiceImpl;
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
    private ProductServiceImpl productService;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/get/all/products")
    public List<Product> getAllProducts(){
       return productService.getAllProducts();
    }

    @GetMapping("/get/products/by/{categoryName}")
    public List<Product> getProductsByCategory(
            @PathVariable(value = "categoryName") String categoryName){

        return productService.getProductsByCategory(categoryName);
    }

    @GetMapping("/find/product/by/name/{product_name}")
    public List<Product> getProductByName(
            @PathVariable(value = "product_name") String product_name) {
        return productService.findProductByName(product_name);
    }


}
