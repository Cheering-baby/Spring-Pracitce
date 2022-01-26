package com.example.springpractice.controller;

import com.example.springpractice.entity.Result;
import com.example.springpractice.entity.User;
import com.example.springpractice.errorEnum.ServiceError;
import com.example.springpractice.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@RestController// This means that this class is a Controller
@RequestMapping(path = "/user") // This means URL starts with /demo (After Application Path)
public class UserController {
  private final UserRepository userRepository;

  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @PostMapping(path = "/addUser") // Map only post request
  public Result addNewUser(@RequestBody User newUser) {
    if (newUser.getUsername() == null) {
      return new Result<>().fail(ServiceError.USER_NAME_REQUIRED.getMsg());
    }
    if (newUser.getPassword() == null) {
      return new Result<>().fail(ServiceError.USER_PWD_REQUIRED.getMsg());
    }
    Base64.Encoder encoder = Base64.getEncoder();
    String pwd = new String(encoder.encode(newUser.getPassword().getBytes(StandardCharsets.UTF_8)));
    newUser.setPassword(pwd);
    userRepository.save(newUser);
    return new Result().success(null);
  }

  @GetMapping("/queryAllUser")
  public Result getAllUser() {
    return new Result().success(userRepository.findAll());
  }

  @GetMapping("/currentUser")
  public Result currentUser(HttpSession session) {
    String username = (String) session.getAttribute("username");

    if(username == null) {
      return new Result<>().fail(ServiceError.USER_NEED_LOGIN.getMsg());
    }

    User findUser = userRepository.findByUsername(username);
    if(findUser == null) {
      return new Result<>().fail(ServiceError.USER_NOT_FOUND.getMsg());
    }
    return new Result().success(findUser);
  }
}
