package com.example.demo.controller;

import com.example.demo.global.RtnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.MimeMessage;
import java.io.File;

/*
@author  zhaihaibo
@data 2020/3/3 - 17:14
*/
@RestController
public class SendEmialController {

    @Autowired
    JavaMailSenderImpl mailSender;

    //发送简单邮件
    @GetMapping(value = "/send/SimpleEmail")
    public RtnResult sendSimpleEmail(){
        System.out.println("编辑简单邮件内容==========>");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("今晚做饭！");
        message.setText("今晚不仅你做饭，你还待刷碗，听到没？");

        message.setTo("1019157840@qq.com");
        message.setFrom("1149513559@qq.com");
        mailSender.send(message);
        System.out.println("简单邮件发送成功==========>");
        return RtnResult.success();
    }

    //发送复杂邮件
    @GetMapping(value = "/send/ComplexEmail")
    public  RtnResult sendComplexEmail() throws Exception {
        System.out.println("编辑复杂邮件内容=================>");
        //1。创建一个复杂邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //使用mimeMessageHelper填充邮件内容 ，为true代表允许上传文件
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);

        helper.setSubject("通知-今晚开会");
        helper.setText("<b style='color:red'>今晚7点集合，刘主任有重要发话</b>",true); //保证样式生效
        helper.addAttachment("1.pdf",new File("C:\\Users\\翟海波\\Desktop\\翟海波简历.pdf"));

        helper.setTo("1019157840@qq.com");
        helper.setFrom("1149513559@qq.com");

        mailSender.send(mimeMessage);
        System.out.println("发送复杂邮件成功=================>");
        return  RtnResult.success();
    }
}
