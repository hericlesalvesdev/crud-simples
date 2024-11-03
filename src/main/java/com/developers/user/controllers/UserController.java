package com.developers.user.controllers;

import com.developers.user.entities.User;
import com.developers.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users")

public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    List<User> findAll() {
        return userRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public User findById(@PathVariable Long id) {
        User result = userRepository.findById(id).get();
        return result;
    }

    @PostMapping
    public User insert(@RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping
    public void delete(@RequestBody User user) {
        userRepository.delete(user);
    }
}
