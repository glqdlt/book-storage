package com.glqdlt.bookstorage.presistence;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
