package com.example.demo.User;

import com.example.demo.User.config.AsynMethod;
import com.example.demo.User.config.applicationConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;


//@RestController
public class UserController {

    private  final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private applicationConfig  api;

    @RequestMapping("/user/detail")
    public String getDeetail(){
       // HttpHeaders headers = request.getHeaders();
        log.info("进入Controller方法-------------------"+Thread.currentThread().getName());
        String secret = api.getSecret();
        AsynMethod asynMethod = new AsynMethod();
        asynMethod.say(666);
        int length = api.getAuth().getPassword().getLength();
        return  "123";
    }
}
