package com.example.demo.repository;

import com.example.demo.entities.Macbook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MacbookRepository extends CrudRepository<Macbook,Long> {
}
