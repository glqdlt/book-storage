package com.glqdlt.bookstorage.utill;

import com.glqdlt.bookstorage.utill.mail.MailSender;
import com.glqdlt.bookstorage.utill.mail.model.MailUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.mail.EmailException;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;


@Slf4j
@RunWith(SpringRunner.class)
public class MailSenderTest {

    @PropertySource("classpath:mail-config-test.properties")
    @TestConfiguration
    static class MailSenderConfiguration {

        @Value("${mail.sender.email}")
        private String email;

        @Value("${mail.sender.id}")
        private String id;

        @Value("${mail.sender.pw}")
        private String password;

        @Value("${mail.sender.port}")
        private String port;

        @Value("${mail.sender.host}")
        private String host;

        @Bean
        public MailSender mailSender(){
            return new MailSender();
        }

        @Bean
        public MailUser mailUser(){
            return MailUser.builder().id(id).pw(password).email(email).port(port).host(host).build();
        }
    }


    @Autowired
    MailSender mailSender;

    @Autowired
    MailUser mailUser;

    public static void initMailUser(MailUser mailUser){
        Assert.assertNotNull(mailUser.getEmail());
        Assert.assertNotNull(mailUser.getHost());
        Assert.assertNotNull(mailUser.getId());
        Assert.assertNotNull(mailUser.getPw());
        Assert.assertNotNull(mailUser.getPort());
    }

    @Test
    public void init() {
        initMailUser(this.mailUser);
    }

    @Ignore
    @Test
    public void shouldSendMail() throws EmailException {
        mailSender.sendMail("glqdlt@gmail.com","\"glqdlt\"님 반납기한이 2일 남았습니다","하야쿠 반납해라구");
    }
}