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
import org.springframework.transaction.annotation.Transactional;

import javax.sound.sampled.Line;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


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

    @Transactional
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
                new Book("bowWow", Stream.of(jhun).collect(Collectors.toSet())),
                new Book("ooo", Stream.of(jhun).collect(Collectors.toSet())),
                new Book("www", savedAuthros)
        );

        bookRepository.save(books);

    }

    @Test
    public void findAuthors() {
        Assert.assertEquals(3, authorRepository.findAll().size());
    }

    @Test
    public void findBook() {
        Assert.assertEquals("bowWow", bookRepository.findByTitle("bowWow").getTitle());
    }

    @Test
    public void findBookIfNull() {
        Assert.assertNull(bookRepository.findByTitle("hahaha"));
    }

    @Test
    public void findBooksByAuthor() {

        Author aa = authorRepository.findByName("jhun");
        List<Book> ss = Arrays.asList(bookRepository.findByAuthor(aa));
        List<Book> ee = bookRepository.findAll();



//         아래 3개는 같은 효과
        ss.forEach(x -> log.info(x.toString()));
        bookRepository.findAllByAuthor_Name("jhun").forEach(x -> log.info(x.toString()));
        log.info("===");
        bookRepository.findBooksByAuthor_Name("jhun").forEach(x -> log.info(x.toString()));


//        FIXME 문제는 jhun 이라는 name을 가지는 author는 여러 개 있는 데, findAll 로 때려도 맨 마지막 하나의 녀석만 나오는 게 문제이다.
        Assert.assertEquals(4, (int) bookRepository.countAllByAuthor_Name("jhun"));


    }
}