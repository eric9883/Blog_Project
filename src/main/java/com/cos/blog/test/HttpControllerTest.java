package com.cos.blog.test;

import org.springframework.web.bind.annotation.*;

@RestController
public class HttpControllerTest {

    private static final String TAG = "HttpControllerTest: ";

    /*
    @GetMapping("/http/lombok")
    public String lombokTest(){
        Member m = Member.builder().username("ssar").password("1234").email("ssar@nate.com").build();
        System.out.println(TAG + "getter: "+m.getUsername());

        return "get request";
    }*/

    //http://localhost:8080/http/get
    @GetMapping("/http/get")
    public String getTest(Member m){

        return "get request: " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
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
