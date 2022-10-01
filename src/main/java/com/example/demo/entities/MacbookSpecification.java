package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class MacbookSpecification {

    private String macbook_processor;
    private Integer macbook_ram;



}
