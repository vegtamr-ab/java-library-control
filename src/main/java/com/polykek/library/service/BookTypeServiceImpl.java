package com.polykek.library.service;

import com.polykek.library.entity.BookType;
import com.polykek.library.exception.BookTypeNotFoundException;
import com.polykek.library.repository.BookTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookTypeServiceImpl implements BookTypeService {
    private final BookTypeRepository bookTypeRepository;

    @Override
    public List<BookType> listBookTypes() {
        return (List<BookType>) bookTypeRepository.findAll();
    }

    @Override
    public BookType findBookType(long id) {
        Optional<BookType> optionalBookType = bookTypeRepository.findById(id);
        if (optionalBookType.isPresent()) {
            return optionalBookType.get();
        } else {
            throw new BookTypeNotFoundException("Book not found!");
        }
    }

    @Override
    public BookType addBookType(BookType bookType) {
        return bookTypeRepository.save(bookType);
    }

    @Override
    public BookType updateBookType(long id, BookType bookType) {
        BookType existingBookType = findBookType(id);
        BeanUtils.copyProperties(bookType, existingBookType);
        return bookTypeRepository.save(existingBookType);
    }

    @Override
    public void deleteBookType(long id) {
        bookTypeRepository.delete(findBookType(id));
    }
}
