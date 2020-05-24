package com.polykek.library.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class BookType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "cnt")
    private Integer count;

    @Column(name = "fine")
    private Integer fine;

    @Column(name = "day_count")
    private Integer dayCount;
}
