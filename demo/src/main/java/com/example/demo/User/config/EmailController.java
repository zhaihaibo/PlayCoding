package com.example.demo.User.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/sendEmail")
    public String sendEmail(){
        Email email = new Email();
        email.setFromEmial("zhaihaibo");
        email.setToEmail("liuyao");
        email.setContent("tiantianxiangshang");
        emailService.sendEmail(email);
        return "1";
    }

}
