package com.polykek.library.service;

import com.polykek.library.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> listBooks();

    Book findBook(long id);
}
