package com.example.demo.repository;

import com.example.demo.entities.Iphone;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IphoneRepository extends CrudRepository<Iphone,Long> {

    @Query(
            value = "SELECT * FROM iphones WHERE Nazwa = ?1",
            nativeQuery = true
    )
    List<Iphone> findByIphoneName(
            @Param("iphoneName")String puttedIphoneName
    );





}
