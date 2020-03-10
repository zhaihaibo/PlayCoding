package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.global.RtnResult;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/*
@author  zhaihaibo
@data 2020/3/9 - 18:25
*/
@RestController
public class UserLoginController {


    @Autowired
    LoginService loginService;


    @PostMapping(value = "/login")
    public RtnResult login (@RequestBody User user , HttpSession session){
        User userByAccount = loginService.getUserByAccount(user.getId());
        session.setAttribute("user",userByAccount);

        return  RtnResult.success(userByAccount);
    }
}
