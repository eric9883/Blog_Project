package com.cos.blog.test;

import org.springframework.web.bind.annotation.*;

@RestController
public class HttpControllerTest {

    @GetMapping("/http/get")
    public String getTest(){
        return "get request";
    }

    @PostMapping("/http/post")
    public String postTest(){
        return "post request";
    }

    @PutMapping("/http/put")
    public String putTest(){
        return "put request";
    }

    @DeleteMapping("/http/delete")
    public String deleteTest(){
        return "delete request";
    }

}
