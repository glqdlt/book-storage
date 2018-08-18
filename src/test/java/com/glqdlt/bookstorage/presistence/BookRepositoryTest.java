package com.glqdlt.bookstorage.presistence;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;



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
        Author author_jhun = authorRepository.findByName("jhun");
        Book book_bowwow = new Book();
        book_bowwow.setAuthors(Arrays.asList(author_jhun));
        book_bowwow.setTitle("bowWow");

        Book aaa = new Book();
        aaa.setAuthors(savedAuthros);
        aaa.setTitle("aaa");

        bookRepository.save(Arrays.asList(book_bowwow,aaa));

    }

    @Test
    public void findAuthors() {
        Assert.assertEquals(2, authorRepository.findAll().size());
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
        Assert.assertEquals(2, (int) bookRepository.countAllByAuthors_Name("jhun"));
    }

    @Test
    public void findJpql() {
        Assert.assertEquals(2, bookRepository.findAllByAuthors_NameJpql("jhun").size());
    }

    @Test
    public void findBooksByAuthors(){
        Assert.assertEquals(2,bookRepository.findBooksByAuthors_Name("jhun").size());
    }

    @Test
    public void findByNo() {
//        no 가 1일거라고 생각했지만, book_no 를 database에 생성하도록 위임했더니,  이런 결과가 생겼다 ㅡㅡ; autogenerated 때문이다.. 음. 이걸 어쩐담
//        Book(no=5, title=bowWow, authors=[Author(no=5, name=jhun, regDate=Sat Aug 18 16:08:22 KST 2018)], regDate=Sat Aug 18 16:08:22 KST
//        Book(no=6, title=aaa, authors=[Author(no=5, name=jhun, regDate=Sat Aug 18 16:08:22 KST 2018), Author(no=6, name=glqdlt, regDate=Sat
        bookRepository.findAll().forEach(x -> log.info(x.toString()));
        Assert.assertEquals("bowWow",bookRepository.findByNo(1).getTitle());
    }
}