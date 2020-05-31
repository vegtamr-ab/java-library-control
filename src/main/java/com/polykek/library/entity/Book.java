package com.polykek.library.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "cnt")
    private Integer count;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private BookType bookType;
}
