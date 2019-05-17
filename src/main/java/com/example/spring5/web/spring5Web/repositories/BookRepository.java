package com.example.spring5.web.spring5Web.repositories;

import com.example.spring5.web.spring5Web.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
