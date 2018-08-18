package com.glqdlt.bookstorage.service;

import com.glqdlt.bookstorage.utill.mail.MailSender;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MailService {

    @Autowired
    MailSender mailSender;

    public void sendMail(String receiver, String subject, String message) {
        try {
            mailSender.sendMail(receiver, subject, message);
        } catch (EmailException e) {
            log.error(e.getMessage(),e);
        }
    }

}
