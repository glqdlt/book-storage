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
import java.util.List;

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
    public void setUp(){

        List<Author> authors = Arrays.asList(

                new Author("jhun"),
                new Author("glqdlt")
        );

        authorRepository.save(authors);

    }

    @Test
    public void findAuthors() {
        Assert.assertEquals(2,authorRepository.findAll().size());
    }
}