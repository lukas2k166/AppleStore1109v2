package com.example.demo.entities;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "Macbooks")
public class Macbook {

    @Id
    @GeneratedValue
    @Column(name = "\"ID\"")
    private Long macbook_id;

    @Column(name = "\"Nazwa\"")
    private String macbook_name;

    @Column(name = "\"Cena\"")
    private BigDecimal macbook_price;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(column = @Column(name = "\"Procesor\""),name = "macbook_processor"),
            @AttributeOverride(column = @Column(name = "\"RAM\""),name = "macbook_ram")
    })
    private MacbookSpecification macbookSpecification;

    @OneToOne(
            targetEntity = Macbook.class
    )
    private Product product;


}
