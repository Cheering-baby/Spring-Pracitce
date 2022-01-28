package com.example.springpractice;

import com.example.springpractice.entity.User;
import com.example.springpractice.repository.UserRepository;
import com.example.springpractice.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
class SpringPracticeApplicationTests {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        Boolean is = userRepository.existsById(new Integer(2));
        assertTrue(is);
    }

    @Test
    public void testFindUserByUserCode() {
        ArrayList<User> users = userRepository.findByRoleCode("ADMIN");
        System.out.println(users.toString());
        assertTrue(users.size() > 0);
    }

    @Test
    public void testUpdate() {
        userService.update(2, "2");
    }

}
