package com.glqdlt.bookstorage.presistence;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@RequiredArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Author {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer no;
    @NonNull
    private String name;
    private Date regDate = new Date();
}
