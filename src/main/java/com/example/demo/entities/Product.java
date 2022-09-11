package com.example.demo.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "Produkty")
//@ToString(exclude = "macbook")
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "\"Product ID\"")
    private Long product_id;

    @Column(name = "\"Nazwa\"")
    private String product_name;

    @Column(name = "\"Cena\"")
    private BigDecimal product_price;


    @OneToOne(
            mappedBy = "product"
    )
    private Macbook macbook;


}
