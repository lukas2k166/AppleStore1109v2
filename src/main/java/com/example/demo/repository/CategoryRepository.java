package com.example.demo.repository;

import com.example.demo.entities.Category;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {


    @Modifying
    @Transactional
    @Query(
            value = "UPDATE Category c " +
                    "SET c.categoryName = ?2" +
                    " WHERE c.id = ?1"
    )
    void editCategory(
            Long id,
            String categoryName
    );




}
