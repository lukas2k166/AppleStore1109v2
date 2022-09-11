package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "Produkty")
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "\"ID\"")
    private Long product_id;

    @Column(name = "\"Nazwa\"")
    private String product_name;

    @Column(name = "\"Cena\"")
    private BigDecimal product_price;






}
