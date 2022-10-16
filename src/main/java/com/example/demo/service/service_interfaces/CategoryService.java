package com.example.demo.service.service_interfaces;

public interface CategoryService {

    void addNewCategory(String categoryName);

    void addCategoryToProduct(String product_name, String categoryName);

}
