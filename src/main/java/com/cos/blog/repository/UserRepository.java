package com.cos.blog.repository;

import com.cos.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

//  DAO
//  automatically Bean register
//  @Repository can be omitted
public interface UserRepository extends JpaRepository<User, Integer> {
}