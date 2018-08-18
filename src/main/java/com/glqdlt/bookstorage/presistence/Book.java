package com.glqdlt.bookstorage.presistence;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Book {

    @NonNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private String title;

    @NonNull
    @OneToMany(targetEntity = Author.class)
    private Set<Author> author;

    private Date regDate = new Date();

}
