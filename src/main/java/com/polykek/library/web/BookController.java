package com.polykek.library.web;

import com.polykek.library.entity.Book;
import com.polykek.library.exception.BookNotFoundException;
import com.polykek.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/books/all")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> list = bookService.listBooks();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") long id) {
        try {
            return new ResponseEntity<>(bookService.findBook(id), HttpStatus.OK);
        } catch (BookNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found!");
        }
    }

    @PostMapping(value = "/books/add", consumes = "application/json", produces = "application/json")
    public Book addBook(@RequestBody Book newBook) {
        return bookService.addBook(newBook);
    }
}
