package com.animals.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "animals")
@AllArgsConstructor
public class Animal {

    //this is a small change so that i have something to commit
    //to test issue referencing

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;
}
