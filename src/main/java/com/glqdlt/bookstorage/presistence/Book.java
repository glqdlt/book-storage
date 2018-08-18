package com.glqdlt.bookstorage.presistence;

import lombok.Data;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@Data
public class Book {

    private String title;
    private Author author;

    private Date regDate;

}
