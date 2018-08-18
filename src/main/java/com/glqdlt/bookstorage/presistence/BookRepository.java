package com.glqdlt.bookstorage.presistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface BookRepository extends JpaRepository<Book,Integer> {

    Book findByTitle(String title);
    Collection<Book> findAllByAuthor(Author author);
    Book findByAuthor(Author author);

    Collection<Book> findAllByAuthor_Name(String name);
    Collection<Book> findBooksByAuthor_Name(String name);

    Integer countAllByAuthor_Name(String name);


}
