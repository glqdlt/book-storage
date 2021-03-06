package com.glqdlt.bookstorage.presistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Integer> {

    Author findByName(String name);
}
