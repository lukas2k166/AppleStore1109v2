package com.example.demo.repository;

import com.example.demo.entities.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo extends CrudRepository<Cart,Long> {
}
