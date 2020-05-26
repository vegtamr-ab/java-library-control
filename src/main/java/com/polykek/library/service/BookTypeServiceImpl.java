package com.polykek.library.service;

import com.polykek.library.entity.BookType;
import com.polykek.library.repository.BookTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookTypeServiceImpl implements BookTypeService {
    private final BookTypeRepository bookTypeRepository;

    @Override
    public List<BookType> listBookTypes() {
        return (List<BookType>) bookTypeRepository.findAll();
    }
}
