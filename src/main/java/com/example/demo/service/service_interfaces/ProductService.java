package com.example.demo.service.service_interfaces;

import com.example.demo.entities.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    List<Product> getProductsByCategory(String categoryName);

    List<Product> findProductByName(String product_name);





}
