package com.example.spring5.web.spring5Web.bootstrap;

import com.example.spring5.web.spring5Web.models.Author;
import com.example.spring5.web.spring5Web.models.Book;
import com.example.spring5.web.spring5Web.models.Publisher;
import com.example.spring5.web.spring5Web.repositories.AuthorRepository;
import com.example.spring5.web.spring5Web.repositories.BookRepository;
import com.example.spring5.web.spring5Web.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(
            AuthorRepository authorRepository,
            BookRepository bookRepository,
            PublisherRepository publisherRepository
    ) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        // Eric
        Publisher harper = new Publisher("Harper Collins", "Texas, Usa");
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", harper);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        publisherRepository.save(harper);
        authorRepository.save(eric);
        bookRepository.save(ddd);

        // Rod
        Publisher worx = new Publisher("Worx", "Atlanta, US");
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", worx);
        rod.getBooks().add(noEJB);

        publisherRepository.save(worx);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
