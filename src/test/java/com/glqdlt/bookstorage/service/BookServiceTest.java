package com.glqdlt.bookstorage.service;

import com.glqdlt.bookstorage.presistence.Author;
import com.glqdlt.bookstorage.presistence.AuthorRepository;
import com.glqdlt.bookstorage.presistence.Book;
import com.glqdlt.bookstorage.presistence.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.junit.Assert.*;

@Slf4j
@RunWith(SpringRunner.class)
public class BookServiceTest {

    @MockBean
    BookRepository bookRepository;

    @MockBean
    AuthorRepository authorRepository;

    @Autowired
    BookService bookService;

    @TestConfiguration
    static class BookSerivceConfiguration {

        @Bean
        public BookService bookService() {
            return new BookService();
        }
    }

    Book book;

    @Before
    public void setUp() throws Exception {
        book = new Book();
        book.setNo(1);
        book.setTitle("haha");
        book.setAuthors(Arrays.asList(new Author("asd")));

        BDDMockito.given(bookRepository.findByNo(1)).willReturn(book);
    }

    @Test
    public void findByNo() {
        Assert.assertEquals(book.getTitle(), bookService.findByBookNo(1).getTitle());

    }

    @Test
    public void findByNull() {

        Assert.assertNull(bookService.findByBookNo(2));
    }
}