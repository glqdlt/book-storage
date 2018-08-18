package com.glqdlt.bookstorage;

import com.glqdlt.bookstorage.presistence.AuthorRepository;
import com.glqdlt.bookstorage.presistence.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = "com.glqdlt.bookstorage.**")
@SpringBootApplication
public class BookStorageApplication implements CommandLineRunner {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(BookStorageApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {


    }
}
