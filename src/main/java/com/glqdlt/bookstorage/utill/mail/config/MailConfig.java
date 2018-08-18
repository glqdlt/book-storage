package com.glqdlt.bookstorage.utill.mail.config;

import com.glqdlt.bookstorage.utill.mail.model.MailUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MailConfig {

    @Value("${mail.sender.id}")
    private String id;

    @Value("${mail.sender.pw}")
    private String pw;

    @Value("${mail.sender.email}")
    private String email;

    @Value("${mail.sender.host}")
    private String host;

    @Value("${mail.sender.port}")
    private String port;

    @Bean
    public MailUser mailUser() {
        return MailUser.builder().id(id).pw(pw).email(email).port(port).host(host).build();
    }

}
