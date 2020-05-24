package com.polykek.library.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "pather_name")
    private String patherName;

    @Column(name = "passport_seria", nullable = false)
    private String passportSeria;

    @Column(name = "passport_num", nullable = false)
    private String passportName;
}
