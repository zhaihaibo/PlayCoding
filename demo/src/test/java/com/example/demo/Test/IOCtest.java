package com.example.demo.Test;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public class IOCtest {
    @Test
    public void test1(){
        BeanFactory beanFactory =   new DefaultListableBeanFactory();
        Object bean = beanFactory.getBean("User");
        System.out.println(bean);
    }
}
