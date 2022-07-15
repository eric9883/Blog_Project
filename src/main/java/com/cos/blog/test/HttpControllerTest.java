package com.cos.blog.test;

import org.springframework.web.bind.annotation.*;

@RestController
public class HttpControllerTest {

    //http://localhost:8080/http/get
    @GetMapping("/http/get")
    public String getTest(){
        return "get request";
    }

    //http://localhost:8080/http/post
    @PostMapping("/http/post")
    public String postTest(){
        return "post request";
    }

    //http://localhost:8080/http/put
    @PutMapping("/http/put")
    public String putTest(){
        return "put request";
    }

    //http://localhost:8080/http/delete
    @DeleteMapping("/http/delete")
    public String deleteTest(){
        return "delete request";
    }

}
