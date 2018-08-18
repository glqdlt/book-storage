package com.glqdlt.bookstorage.presistence;

import lombok.Data;

import javax.persistence.Entity;
import java.util.Date;

@Data
@Entity
public class Author {
    private Integer no;
    private String name;
    private Date regDate;
}
