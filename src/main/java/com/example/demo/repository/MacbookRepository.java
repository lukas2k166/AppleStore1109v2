package com.example.demo.repository;

import com.example.demo.entities.Macbook;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MacbookRepository extends CrudRepository<Macbook,Long> {

    @Query(
            value = "SELECT * FROM macbooks WHERE Nazwa = ?1",
            nativeQuery = true
    )
    List<Macbook> findByMacbookName(
            @Param("macbookName")String puttedMacbookName
    );



}
