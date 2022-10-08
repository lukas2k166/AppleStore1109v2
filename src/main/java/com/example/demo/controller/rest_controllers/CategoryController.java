package com.example.demo.controller.rest_controllers;

import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category/")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("add/category/{categoryName}")
    public void addNewCategory(@PathVariable(value = "categoryName") String categoryName){
        categoryService.addNewCategory(categoryName);
    }

    @GetMapping("lol")
    public void editCategory(
    @PathVariable(value = "id") Long id,
         @PathVariable(value = "categoryName") String categoryName
    ){

        categoryService.editCategory(id, categoryName);

    }





}
