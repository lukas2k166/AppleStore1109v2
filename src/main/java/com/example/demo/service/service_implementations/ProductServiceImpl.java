package com.example.demo.service.service_implementations;

import com.example.demo.entities.Product;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.MacbookRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.service_interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private MacbookRepository macbookRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public List<Product> getProductsByCategory(String categoryName){
        return productRepository.findProductsByCategory(categoryName);
    }

    public List<Product> findProductByName(String product_name){
        if (productRepository.findByProductName(product_name).isEmpty())
            throw new ResourceNotFoundException(product_name + " cannot be found");

        return productRepository.findByProductName(
                product_name
        );
    }




}
