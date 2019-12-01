package com.example.demo.Test;

import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public User user(){
        return  new User();
    }
}
