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
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    @Column(name = "\"Product ID\"")
    private Long product_id;

    @Column(name = "\"Nazwa\"")
    private String product_name;

    @Column(name = "\"Cena\"")
    private BigDecimal product_price;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "\"Kategoria\"",
            referencedColumnName = "id"
    )
    private Category category;

    @JsonIgnore
    @OneToOne(
            mappedBy = "product"
    )
    private Macbook macbook;

    @JsonIgnore
    @OneToOne(
            mappedBy = "product"
    )
    private Iphone iphone;




}
