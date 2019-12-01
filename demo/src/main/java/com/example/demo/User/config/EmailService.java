package com.example.demo.User.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private Email email;
    @Autowired
    private EmailProduce emailProduce;

     private Logger log = LoggerFactory.getLogger(EmailService.class);

     //发送单个文字邮件
     public void sendEmail(Email email){
        excuteAsyn(email);
     }


     //调用异步线程
    @Async("getAsyncExecutor")
    public void excuteAsyn(Email email){

         emailProduce.setEmail(email);
         emailProduce.run();
    }



}
