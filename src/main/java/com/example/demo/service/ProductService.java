package com.example.demo.service;

import com.example.demo.entities.Product;
import com.example.demo.repository.MacbookRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private MacbookRepository macbookRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
}
