package com.example.demo.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "Iphones")
@ToString(exclude = "product")
public class Iphone {


    @Id
    @SequenceGenerator(
            name = "iphone_sequence",
            sequenceName = "iphone_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "iphone_sequence"
    )
    @Column(name = "\"Iphone ID\"")
    private Long iphone_id;


    @Column(name = "\"Nazwa\"")
    private String iphone_name;

    @Column(name = "\"Cena\"")
    private BigDecimal iphone_price;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "\"Product ID\"",
            referencedColumnName = "\"Product ID\""
    )
    private Product product;






}
