package com.example.demo.User.cycleReference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class B {

    @Autowired
    A a;
    public B( A a){
        System.out.println("b的构造器中引用了A))))))))))))))))))))))");
    }
}
