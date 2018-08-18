package com.glqdlt.bookstorage.presistence;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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
    @OneToMany()
    @JoinColumn(name = "author_no")
    private Collection<Author> author;

    private Date regDate = new Date();

}
