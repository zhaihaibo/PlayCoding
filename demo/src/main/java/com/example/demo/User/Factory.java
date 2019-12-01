package com.example.demo.User;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Factory {
    public static void main(String[] args) {
        //这个创建容器无法加载配置文件的东西
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Configuration.class);
        User user = context.getBean(User.class);
        System.out.println(user);
        System.out.println(user.getName());
    }
}
