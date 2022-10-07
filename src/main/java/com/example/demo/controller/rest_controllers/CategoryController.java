package com.example.demo.controller.rest_controllers;

import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category/")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("add/category/{categoryName}")
    public void addNewCategory(@PathVariable(value = "categoryName") String categoryName){
        categoryService.addNewCategory(categoryName);
    }
}
