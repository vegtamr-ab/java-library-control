package com.polykek.library.repository;

import com.polykek.library.entity.BookType;
import org.springframework.data.repository.CrudRepository;

public interface BookTypeRepository extends CrudRepository<BookType, Long> {
}
