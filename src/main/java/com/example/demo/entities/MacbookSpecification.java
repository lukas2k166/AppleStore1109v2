package com.example.demo.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Embeddable
public class MacbookSpecification {

    private String macbook_processor;
    private Integer macbook_ram;


}
