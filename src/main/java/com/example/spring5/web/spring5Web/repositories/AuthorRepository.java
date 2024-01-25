package com.example.spring5.web.spring5Web.repositories;

import com.example.spring5.web.spring5Web.models.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
