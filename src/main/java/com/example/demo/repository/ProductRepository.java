package com.example.demo.repository;

import com.example.demo.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {


    @Query(
            value = "SELECT * FROM Produkty WHERE Kategoria = ?1",
            nativeQuery = true
    )
    List<Product> findProductsByCategory(
            String categoryName
    );



}
