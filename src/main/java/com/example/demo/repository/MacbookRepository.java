package com.example.demo.repository;

import com.example.demo.entities.Macbook;
import com.example.demo.entities.MacbookSpecification;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
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

    @Modifying
    @Transactional
    @Query(
            value = "UPDATE Macbook macbook " +
                    "SET macbook.macbook_name = ?2," +
                    "macbook.macbook_price= ?3" +
                    " WHERE macbook.macbook_id = ?1"
    )
    void updateMacbook(
            Long macbook_id,
            String macbook_name,
            BigDecimal macbook_price
    );

}
