package com.example.spring5.web.spring5Web.repositories;

import com.example.spring5.web.spring5Web.models.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
