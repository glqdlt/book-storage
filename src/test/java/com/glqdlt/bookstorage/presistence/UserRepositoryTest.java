package com.glqdlt.bookstorage.presistence;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;


@Slf4j
@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Before
    public void setUp() throws Exception {

        User jhun = new User();
        jhun.setId("jhun");
        jhun.setPassword("jhun1234");
        jhun.setEmail("jhun@jhun.com");
        jhun.setName("jiw");

        userRepository.save(Stream.of(jhun).collect(Collectors.toList()));
    }


    @Test
    public void findUserByName() {

        Assert.assertEquals(1,userRepository.findAllByName("jiw").size());

    }
}