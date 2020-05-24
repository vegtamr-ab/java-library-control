package com.polykek.library.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Journal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @Column(name = "book_id")
    private Book book;

    @ManyToOne
    @Column(name = "client_id")
    private Client client;

    @Column(name = "date_beg")
    private Date dateBegin;

    @Column(name = "date_end")
    private Date dateEnd;

    @Column(name = "date_ret")
    private Date dateReturn;
}
