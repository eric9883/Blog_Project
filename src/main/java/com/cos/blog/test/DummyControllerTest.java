package com.cos.blog.test;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyControllerTest {

    @Autowired  //  dependency injection
    private UserRepository userRepository;


    //  http://localhost:8000/blog/dummy/join (request)
    //  username, password, email data request to http Body
    @PostMapping("dummy/join")
    public String join(User user){ //key = value

        System.out.println("id: " + user.getId());
        System.out.println("username: " + user.getUsername());
        System.out.println("password: " + user.getPassword());
        System.out.println("email: " + user.getEmail());
        System.out.println("role: " + user.getRole());
        System.out.println("createDate: " + user.getCreateDate());


        user.setRole(RoleType.USER);
        userRepository.save(user);

        return "user sign up(join) complete.";

    }
}
