package com.glqdlt.bookstorage.service;

import com.glqdlt.bookstorage.utill.mail.model.MailUser;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static com.glqdlt.bookstorage.utill.MailSenderTest.initMailUser;
import static org.junit.Assert.*;

@ActiveProfiles("product")
@SpringBootTest
@RunWith(SpringRunner.class)
public class MailServiceTest {

    @Autowired
    MailService mailService;

    @Autowired
    MailUser mailUser;

    @Test
    public void init() {
        initMailUser(this.mailUser);
    }

    @Ignore
    @Test
    public void sendedMail() {
        mailService.sendMail("glqdlt@gmail.com","asd","dd");
    }
}