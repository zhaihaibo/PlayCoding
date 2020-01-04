package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.util.SpringApplicationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class UserController {
    private  Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    @GetMapping(value = "get/all")
    @ResponseBody
    public List<User> getAll(){
        List<User> users = userService.getAll();
        ApplicationContext applicationContext = SpringApplicationUtil.getApplicationContext();

        User user = SpringApplicationUtil.getBean(User.class);
        User user1 = (User)SpringApplicationUtil.getBean("user");
        logger.info(user.toString()+"--------------------------------->");
        return users ;

    }

    @GetMapping("getOneById/{id}")
    public String getOneById(@PathVariable Integer id){

        User userById = userService.getUserById(id);
        return userById.toString();
    }

    @PostMapping("insert/user")
    public String insertUser ( @RequestBody User user){
        int i = userService.insertUser(user);
        return  i+"";
    }

    @DeleteMapping("deleteById")
    public String deleteById (@RequestParam("id") String id){
        int i = userService.deleteById(id);
        return  i +"";

    }
}
