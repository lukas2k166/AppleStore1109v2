package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name =  "usertest", uniqueConstraints = @UniqueConstraint(columnNames = "usernametest"))
public class UserTest {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long idtest;

    private String usernametest;


    public UserTest(String usernametest) {
        super();
        this.usernametest = usernametest;
    }
}
