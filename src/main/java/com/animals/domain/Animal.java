package com.animals.domain;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "animals")
@AllArgsConstructor
public class Animal {

    @Id
    @Expose
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    @Expose
    @Column(name = "name")
    private String name;
}
