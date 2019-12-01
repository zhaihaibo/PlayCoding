package com.example.demo.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class User  implements InitializingBean {

    private final Logger log = LoggerFactory.getLogger(User.class);

    private  String name;
    private  String age;

    public User() {
    }

    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("initializingBeand的初始化bean方法----------------------");
    }


    @PostConstruct
    public void init(){
        log.info("bean对象的初始化方法-----------------");
    }

    @PreDestroy
    public void destory(){
        log.info("bean对象的销毁方法----------------------");
    }



}
