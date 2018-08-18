package com.glqdlt.bookstorage.controller.api.book;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.glqdlt.bookstorage.presistence.Author;
import com.glqdlt.bookstorage.presistence.AuthorRepository;
import com.glqdlt.bookstorage.presistence.Book;
import com.glqdlt.bookstorage.presistence.BookRepository;
import com.glqdlt.bookstorage.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private AuthorRepository authorRepository;

    @MockBean
    private BookRepository bookRepository;

    @MockBean
    private BookService bookService;
    private Book book;

    @Before
    public void setUp() throws Exception {
        Author author = new Author();
        author.setNo(1);
        author.setName("jhun");


        book = new Book();
        book.setTitle("bowWow");
        book.setNo(1);
        book.setAuthors(Collections.singletonList(author));

        BDDMockito.given(bookService.findByBookNo(1)).willReturn(book);
    }

    @Test
    public void findByBook() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/book/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        ObjectMapper objectMapper = new ObjectMapper();

        Book resultBook = objectMapper.readValue(result.getResponse().getContentAsString(), Book.class);

        log.info(resultBook.toString());
        Assert.assertNotNull(book.getTitle(),resultBook.getTitle());

    }

    @Test(expected = JsonMappingException.class)
    public void findByNull() throws Exception {

        MvcResult result = mockMvc.perform(get("/api/book/2").contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        ObjectMapper objectMapper = new ObjectMapper();

        Book resultBook = objectMapper.readValue(result.getResponse().getContentAsString(), Book.class);
        Assert.assertNull(resultBook);

    }
}