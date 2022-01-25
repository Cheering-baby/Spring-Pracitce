package com.example.springpractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class SessionController {

  @GetMapping("/setMsg")
  public @ResponseBody String setMsg(HttpSession session) {
    session.setAttribute("username", "username");
    return "ok";
  }

  @GetMapping("/getMsg")
  public @ResponseBody String getMsg(HttpSession session) {
    String msg = (String) session.getAttribute("username");
    return msg;
  }
}
