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
import java.util.List;

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
    private List<Author> authors;

    private Date regDate = new Date();

}
