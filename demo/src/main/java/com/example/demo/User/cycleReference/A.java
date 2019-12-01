package com.example.demo.User.cycleReference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

//A和b互相引用，测试依赖注入问题
@Component
public class A {

    @Autowired
    B b;
    public A( @Lazy B b) {
        System.out.println("A的构造器引用b））））））））））））））））））））");
    }
}
