package com.cos.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;


//@DynamicInsert    // exclude null field while DB insert
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity //  automatically create TABLE on MySQL
public class User {

    @Id//  primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // sequence, auto_increment 넘버링


    @Column(nullable = false, length = 30, unique = true)
    private String username; //ID



    @Column(nullable = false, length = 100)
    private String password;


    @Column(nullable = false, length = 50)
    private String email;


    //  @ColumnDefault("user")
    @Enumerated(EnumType.STRING)
    private RoleType role;  //  Enum type is better, ex) admin, user, manager


    @CreationTimestamp //automatically input time stamp
    private LocalDateTime createDate;

}
