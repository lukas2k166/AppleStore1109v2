package com.example.demo.service.service_interfaces;

import com.example.demo.entities.Macbook;

import java.math.BigDecimal;
import java.util.List;

public interface MacbookService {

    List<Macbook> getAllMacbooks();

    void addNewMacbook();

    void updateMacbook(
            Long macbook_id,
            String macbook_name,
            BigDecimal macbook_price,
            String macbook_processor,
            Integer macbook_ram
    );

    void deleteMacbook();

}
