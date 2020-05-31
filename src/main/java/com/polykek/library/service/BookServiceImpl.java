package com.polykek.library.service;

import com.polykek.library.entity.Book;
import com.polykek.library.exception.BookNotFoundException;
import com.polykek.library.repository.BookRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public List<Book> listBooks() {
       return (List<Book>) bookRepository.findAll();
    }

    @Override
    public Book findBook(long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            throw new BookNotFoundException("Book not found!");
        }
    }

    @Override
    public Book addBook(Book book) {
       return bookRepository.save(book);
    }
}
