package com.example.springpractice.controller;

import com.example.springpractice.entity.Result;
import com.example.springpractice.entity.User;
import com.example.springpractice.errorEnum.ServiceError;
import com.example.springpractice.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/login")
public class LoginController {
  private final UserRepository userRepository;

  public LoginController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @PostMapping("/account")
  public Result account(@RequestBody User loginUser, HttpSession session) {

    User findUser = userRepository.findByUsername(loginUser.getUsername());
    if(findUser == null) {
      return new Result<>().fail(ServiceError.USER_NOT_FOUND.getMsg());
    }
    String loginUserPwd = loginUser.getPassword();
    String findUserPwd = findUser.getPassword();
    if(loginUserPwd.equals(findUserPwd) == false) {
      return new Result<>().fail(ServiceError.USER_PWD_ERROR.getMsg());
    }
    session.setAttribute("username", findUser.getUsername());
    return new Result().success(null);
  }
}
