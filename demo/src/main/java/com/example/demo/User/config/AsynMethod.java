package com.example.demo.User.config;

import org.springframework.scheduling.annotation.Async;
public class AsynMethod {


    @Async("getAsyncExecutor")
    public void say( int a){

        int i = 0/100;
        System.out.println("我是异步线程方法++++++++++++++++++ "+Thread.currentThread().getName()+"["+a+"]");
    }
}
