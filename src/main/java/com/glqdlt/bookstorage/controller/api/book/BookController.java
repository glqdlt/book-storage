package com.glqdlt.bookstorage.controller.api.book;

import com.glqdlt.bookstorage.presistence.Book;
import com.glqdlt.bookstorage.presistence.BookRepository;
import com.glqdlt.bookstorage.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/{detail}")
    public Book findByBook(@PathVariable("detail") Integer detail) {
        return bookService.findByBookNo(detail);
    }

}
