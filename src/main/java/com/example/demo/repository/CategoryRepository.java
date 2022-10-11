package com.example.demo.repository;

import com.example.demo.entities.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {

    @Query(
            value = "SELECT * FROM Category WHERE category_name = ?1",
            nativeQuery = true
    )
    List<Category> findCategoryByName(
            String categoryName
    );

}
