package com.example.backend.model;


import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "dop_info", nullable = true)
    private String dop_info;

    @Column
    private String email;

}
