package com.example.demo.config;

import com.example.demo.interceptor.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
@author  zhaihaibo
@data 2020/3/9 - 21:54
*/
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Bean
    public MyInterceptor getMyInterceptor(){
        return  new MyInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getMyInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login");
    }
}
