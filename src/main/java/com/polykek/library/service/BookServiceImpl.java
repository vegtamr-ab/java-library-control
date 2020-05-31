package com.polykek.library.service;

import com.polykek.library.entity.Book;
import com.polykek.library.exception.BookNotFoundException;
import com.polykek.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
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

    @Override
    public Book updateBook(long id, Book book) {
        Book existingBook = findBook(id);
        BeanUtils.copyProperties(book, existingBook);
        return bookRepository.save(existingBook);
    }

    @Override
    public void deleteBook(long id) {
        bookRepository.delete(findBook(id));
    }
}
