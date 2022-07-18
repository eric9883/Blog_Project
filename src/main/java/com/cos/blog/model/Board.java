package com.cos.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob
    private String content; // summer note library
                            // <html> is mixed with design

    @ColumnDefault("0")
    private int count; // view count

    @ManyToOne //Many = Board, User = One
    @JoinColumn(name = "userId")
    private User user;


    @CreationTimestamp
    private Timestamp createDate;



}
