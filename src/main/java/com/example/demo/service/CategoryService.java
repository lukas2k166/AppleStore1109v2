package com.example.demo.service;

import com.example.demo.entities.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void addNewCategory(String categoryName){
        Category newCategory = new Category();
        newCategory.setCategory_name(categoryName);
        categoryRepository.save(newCategory);
    }

    public void editCategory(Long id, String categoryName){

        categoryRepository.editCategory(id, categoryName);



    }





}
