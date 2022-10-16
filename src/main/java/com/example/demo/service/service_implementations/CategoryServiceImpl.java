package com.example.demo.service.service_implementations;

import com.example.demo.entities.Category;
import com.example.demo.entities.Product;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.service_interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductServiceImpl productService;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void addNewCategory(String categoryName) {
        Category newCategory = new Category();
        newCategory.setCategory_name(categoryName);
        categoryRepository.save(newCategory);
    }

    public void addCategoryToProduct(String product_name, String categoryName) {

        Product product = productRepository.findByProductName(product_name).stream().findFirst().get();

        try {
            Long existingCategoryID = categoryRepository.findCategoryByName(categoryName).stream().
                    findFirst().get().getId();

            if (categoryRepository.findCategoryByName(categoryName).stream().findAny().isPresent())
                product.setCategory(categoryRepository.findById(existingCategoryID).get());


            } catch (NoSuchElementException e){
                product.setCategory(new Category(categoryName));
            }

        productRepository.save(product);


    }
}









