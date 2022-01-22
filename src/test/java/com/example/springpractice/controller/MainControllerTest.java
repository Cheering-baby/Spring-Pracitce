package com.example.springpractice.controller;

import com.example.springpractice.repository.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@SpringBootTest
public class MainControllerTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void addNewUser() {
    }

    @Test
    public void getAllUser() {
    }
}