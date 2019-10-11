package com.techprimers.controller;

import com.techprimers.model.User;
import com.techprimers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {

	/** The JPA repository */
    @Autowired
    UserService userService;


    @GetMapping(value = "/users")
    public List<User> findAll() {
        return (List<User>) userService.findAll();
    }

    @GetMapping(value = "/users/{id}")
    public User findById(@PathVariable final Long id){
        return userService.findById(id);
    }

    @PostMapping(value = "/users")
    protected User load(@RequestBody final User users) {
        return userService.save(users);
    }

    @PutMapping(value = "/users/{id}")
    public User putMap(@PathVariable final Long id, @RequestBody User user){
        return userService.update(user, id);
    }

    @DeleteMapping(value = "/users/{id}")
    public void deleteUser(@PathVariable final Long id){
        userService.deleteUser(id);
    }
}
