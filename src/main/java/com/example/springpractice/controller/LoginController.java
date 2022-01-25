package com.example.springpractice.controller;

import com.example.springpractice.entity.Result;
import com.example.springpractice.entity.User;
import com.example.springpractice.errorEnum.ServiceError;
import com.example.springpractice.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
public class LoginController {
  private final UserRepository userRepository;

  public LoginController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @PostMapping("/account")
  public @ResponseBody Result account(@RequestBody User loginUser) {

    User findUser = userRepository.findByUsername(loginUser.getUsername());
    if(findUser == null) {
      return new Result<>().fail(ServiceError.USER_NOT_FOUND.getMsg());
    }
    String loginUserPwd = loginUser.getPassword();
    String findUserPwd = findUser.getPassword();
    if(loginUserPwd.equals(findUserPwd) == false) {
      return new Result<>().fail(ServiceError.USER_PWD_ERROR.getMsg());
    }

    return new Result().success(null);
  }
}
