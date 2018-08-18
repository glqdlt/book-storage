package com.glqdlt.bookstorage.presistence;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;


@Slf4j
@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Before
    public void setUp() {

        List<Author> authors = Arrays.asList(

                new Author("jhun"),
                new Author("glqdlt")
        );

        List<Author> savedAuthros = authorRepository.save(authors);


        Author jhun = savedAuthros.get(0);

        List<Book> books = Arrays.asList(

                new Book("jhun의 모험", Stream.of(jhun).collect(Collectors.toSet())),
                new Book("bowWow", Stream.of(jhun).collect(Collectors.toSet()))
        );

        bookRepository.save(books);


    }

    @Test
    public void findAuthors() {
        Assert.assertEquals(2, authorRepository.findAll().size());
    }

    @Test
    public void findBooks() {
        bookRepository.findAll().forEach(x -> log.info(x.toString()));
    }
}