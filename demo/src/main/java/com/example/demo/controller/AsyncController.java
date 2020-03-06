package com.example.demo.controller;

import com.example.demo.global.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
@author  zhaihaibo
@data 2020/3/3 - 16:11
*/
@Controller
public class AsyncController {

    @Autowired
    AsyncService asyncService;

    @RequestMapping("/success")
    @ResponseBody
    public String  hello(){
        asyncService.hello();
        return "success";
    }
}
