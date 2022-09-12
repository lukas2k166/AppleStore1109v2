package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

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
    @Column(name = "\"Product ID\"")
    private Long product_id;

    @Column(name = "\"Nazwa\"")
    private String product_name;

    @Column(name = "\"Cena\"")
    private BigDecimal product_price;

    @JsonIgnore
    @OneToOne(
            mappedBy = "product"
    )
    private Macbook macbook;


}
