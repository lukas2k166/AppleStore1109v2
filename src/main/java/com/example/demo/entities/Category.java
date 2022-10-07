package com.example.demo.entities;

import javax.persistence.*;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

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

     @OneToMany(
            cascade = CascadeType.ALL
    )
    private List<Product> productList;


}
