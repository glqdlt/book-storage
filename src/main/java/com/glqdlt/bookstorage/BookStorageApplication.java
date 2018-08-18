package com.glqdlt.bookstorage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.glqdlt.bookstorage.**")
@SpringBootApplication
public class BookStorageApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookStorageApplication.class, args);
    }
}
