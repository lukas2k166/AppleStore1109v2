package com.example.demo.repository;

import com.example.demo.entities.Iphone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IphoneRepository extends CrudRepository<Iphone,Long> {

}
