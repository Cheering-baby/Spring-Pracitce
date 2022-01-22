package com.example.springpractice.controller;

import com.example.springpractice.entity.User;
import com.example.springpractice.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@Controller // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL starts with /demo (After Application Path)
public class MainController {
    private final UserRepository userRepository;

    public MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @PostMapping(path="/add") // Map only post request
    public @ResponseBody User addNewUser(@RequestBody User newUser) {
        userRepository.save(newUser);
        return newUser;
    }

    @Transactional
    @GetMapping("/all")
    public @ResponseBody Iterable<User> getAllUser() {
        return userRepository.findAll();
    }
}
