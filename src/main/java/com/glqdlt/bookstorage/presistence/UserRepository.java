package com.glqdlt.bookstorage.presistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface UserRepository extends JpaRepository<User,Integer> {

    Collection<User> findAllByName(String name);
}
