package com.cos.blog.test;

import org.springframework.web.bind.annotation.*;

@RestController
public class HttpControllerTest {

    private static final String TAG = "HttpControllerTest: ";

    @GetMapping("/http/lombok")
    public String lombokTest(){
        Member m = Member.builder().username("ssar").password("11234").email("ssar@nate.com").build();
        System.out.println(TAG + "Getter" + m.getId());
        m.setId(5000);
        System.out.println(TAG + "setter" + m.getId());

        return "lombok test complete";
    }

    //http://localhost:8080/http/get
    @GetMapping("/http/get")
    public String getTest(Member m){


        return "get request: " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
    }

    //http://localhost:8080/http/post
    @PostMapping("/http/post") //text/plain, application/json
    public String postTest(@RequestBody Member m){ //MessageConverter(스프링부트)

        return "post request: " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
    }

    //http://localhost:8080/http/put
    @PutMapping("/http/put")
    public String putTest(@RequestBody Member m){
        return " put request: " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
    }

    //http://localhost:8080/http/delete
    @DeleteMapping("/http/delete")
    public String deleteTest(){
        return "delete request";
    }

}
