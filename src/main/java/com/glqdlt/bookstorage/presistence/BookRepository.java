package com.glqdlt.bookstorage.presistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {

    Book findByTitle(String title);
    Collection<Book> findAllByAuthors(Author author);

    Collection<Book> findAllByAuthors_Name(String name);
    Collection<Book> findBooksByAuthors_Name(String name);

    @Query("select b from Book as b join b.authors as a where a.name = :name ")
    List<Book> findAllByAuthors_NameJpql(@Param("name") String name);

    Integer countAllByAuthors_Name(String name);


}
