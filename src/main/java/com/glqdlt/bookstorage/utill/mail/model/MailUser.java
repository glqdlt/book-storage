package com.glqdlt.bookstorage.utill.mail.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MailUser {
    private String id;
    private String pw;
    private String email;
    private String host;
    private String port;
}
