package com.example.demo.controller.rest_controllers;

import com.example.demo.service.service_implementations.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category/")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping("add/category/{categoryName}")
    public void addNewCategory(@PathVariable(value = "categoryName") String categoryName){
        categoryService.addNewCategory(categoryName);
    }

    @RequestMapping (value = "add/category/toProduct/{product_name}/{categoryName}",
            method={RequestMethod.POST, RequestMethod.GET})
    public void addCategoryToProduct(@PathVariable("product_name") String product_name,
                              @PathVariable("categoryName") String categoryName){

        categoryService.addCategoryToProduct(product_name,categoryName);
    }



}
