package com.example.demo.repository;

import com.example.demo.entities.Cart;
import com.example.demo.entities.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {
}
