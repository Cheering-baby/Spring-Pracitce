package com.example.springpractice.service;


import com.example.springpractice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void update(Integer id, String username) {
        userRepository.update(id, username);
    };
}
