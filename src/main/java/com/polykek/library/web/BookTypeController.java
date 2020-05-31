package com.polykek.library.web;

import com.polykek.library.entity.BookType;
import com.polykek.library.service.BookTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BookTypeController {
    private final BookTypeService bookTypeService;

    @GetMapping("/types/all")
    public ResponseEntity<List<BookType>> getAllBookTypes() {
        List<BookType> list = bookTypeService.listBookTypes();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping(value = "/types/add", consumes ="application/json", produces = "application/json")
    public BookType addBookType(@RequestBody BookType newBookType) {
        return bookTypeService.addBookType(newBookType);
    }
}
