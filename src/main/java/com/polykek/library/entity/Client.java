package com.polykek.library.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "pather_name")
    private String patherName;

    @Column(name = "passport_seria")
    private String passportSeria;

    @Column(name = "passport_num")
    private String passportNum;
}
