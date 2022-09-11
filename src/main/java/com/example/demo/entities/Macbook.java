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
    @Column(name = "\"ID Macbooka\"")
    private Long macbook_id;

    @Column(name = "\"Nazwa Macbooka\"")
    private String macbook_name;

    @Column(name = "\"Cena Macbooka\"")
    private BigDecimal macbook_price;


}
