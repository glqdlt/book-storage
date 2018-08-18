package com.glqdlt.bookstorage.utill.mail;

import com.glqdlt.bookstorage.utill.mail.model.MailUser;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MailSender {

    @Autowired
    private MailUser mailUser;

    private static final String charset = "utf-8";

    public void sendMail(String receiver, String subject, String message) throws EmailException {

        Email email = new SimpleEmail();
        email.setHostName(mailUser.getHost());
        email.setSmtpPort(Integer.parseInt(mailUser.getPort()));
        email.setAuthenticator(new DefaultAuthenticator(mailUser.getId(),mailUser.getPw()));
        email.setSSL(true);
        email.setFrom(mailUser.getEmail());
        email.setSubject(subject);
        email.setCharset(charset);
        email.setMsg(message);
        email.addTo(receiver);
        email.send();
    }
}
