package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.global.RtnResult;
import com.example.demo.service.UserService;
import com.example.demo.util.SpringApplicationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
@RestController
public class UserController {
    private  Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    @GetMapping(value = "get/all")
    public RtnResult getAll(HttpSession session){
        User user2 = (User) session.getAttribute("user");
        logger.info(user2+"**************");
        List<User> users = userService.getAll();
        ApplicationContext applicationContext = SpringApplicationUtil.getApplicationContext();

        User user = SpringApplicationUtil.getBean(User.class);
        User user1 = (User)SpringApplicationUtil.getBean("user");
        logger.info(user.toString()+"--------------------------------->");

        return RtnResult.success(users) ;
    }
    @GetMapping("getOneById/{id}")
    public RtnResult getOneById(@PathVariable Integer id){
        User userById = userService.getUserById(id);
        return RtnResult.success(userById);
    }

    @PostMapping("insert/user")
    public RtnResult insertUser ( @RequestBody User user){
        int i = userService.insertUser(user);
        return RtnResult.success();
    }

    @DeleteMapping("deleteById")
    public RtnResult deleteById (@RequestParam("id") String id){
        int i = userService.deleteById(id);
        return  RtnResult.success();
    }
}
