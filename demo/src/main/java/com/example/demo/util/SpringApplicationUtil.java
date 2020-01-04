package com.example.demo.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

//获取spring容器的工具方法
@Component
public class SpringApplicationUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        SpringApplicationUtil.applicationContext = applicationContext;
    }

    //通过容器中的对象名字获取bean对象
    public static Object getBean(String s ){
        return  applicationContext.getBean(s);
    }

    public static <T> T getBean(Class<T> beanClass){
        return  applicationContext.getBean(beanClass);
    }


}
