package com.example.springpractice;

import com.example.springpractice.entity.User;
import com.example.springpractice.repository.UserRepository;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@SpringBootTest(classes = SpringPracticeApplicationTests.class)
@RunWith(SpringRunner.class)
@DataJpaTest
public class UserTest {

    private final UserRepository userRepository;

    public UserTest(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Test
    public void findUserById() {
        Optional<User> user = userRepository.findById(new Integer(1));
        assertNotNull(user);
    }
}
