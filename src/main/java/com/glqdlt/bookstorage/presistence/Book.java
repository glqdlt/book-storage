package com.glqdlt.bookstorage.presistence;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Book {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer no;

    @NonNull
    private String title;

    @NonNull
    @ManyToMany()
    private Collection<Author> authors;

    private Date regDate = new Date();

}
