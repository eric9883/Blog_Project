package com.cos.blog.test;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@RestController
public class DummyControllerTest {

    @Autowired  //  dependency injection
    private UserRepository userRepository;

    @GetMapping("/dummy/users")
    public List<User> list(){
        return userRepository.findAll();
    }

    @GetMapping("/dummy/user")
    public List<User> pageList(@PageableDefault(size=2, sort="id", direction = Sort.Direction.DESC)Pageable pageable){
        Page<User> pagingUser = userRepository.findAll(pageable);

        List<User> users = pagingUser.getContent();

        return users;
    }

    @GetMapping("/dummy/user/{id}")
    public User detail(@PathVariable int id){

        /*
        //  Same as the below ElseThrow.
        //  expression of RAMDA expression
        User user = userRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("No Exact User. ID: " + id);
        });
        */


        User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
            @Override
            public IllegalArgumentException get() {
                return new IllegalArgumentException("No Exact User. ID: " + id);
            }
        });



        return user;
    }


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
