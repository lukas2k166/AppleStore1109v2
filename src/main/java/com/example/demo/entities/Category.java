package com.example.demo.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String category_name;

    public Category() {

    }
    public Category(String category_name) {
        super();
        this.category_name = category_name;
    }

    @JsonIgnore
    @OneToOne(
            mappedBy = "category"
    )
    private Product product;


}
