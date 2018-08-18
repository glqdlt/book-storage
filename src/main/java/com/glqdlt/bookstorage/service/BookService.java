package com.glqdlt.bookstorage.service;

import com.glqdlt.bookstorage.presistence.Book;
import com.glqdlt.bookstorage.presistence.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;


    public Book findByBookNo(Integer no) {
        return bookRepository.findByNo(no);
    }

}
