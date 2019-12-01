package com.example.demo;

import com.example.demo.User.ApplicationListenerTest2;
import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableScheduling
public class DemoApplication {

    private final static Logger log = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) {

        log.info("我是springboot启动类------run 前 ----------");
        ConfigurableEnvironment environment = SpringApplication.run(DemoApplication.class, args).getEnvironment();
        String port = environment.getProperty("server.port");
        String contextPath = environment.getProperty("server.servlet.context-path");
        String property = environment.getProperty("server.ssl.key-store");
        String hostAddress = null;
        try {
             hostAddress = InetAddress.getLocalHost().getHostAddress(); //获取本机ip地址
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        log.info("\n-----------------------------------------\n"+
            "host:{}"+"\taddress:{}"+"\tprofiles:{}"+
                "\n---------------------------------------------",
                port
                ,hostAddress,
                environment.getActiveProfiles()
                );



        log.info("我是springboot启动类------run 后 ----------");
        String s = RandomStringUtils.randomAlphanumeric(6);
        String random = RandomStringUtils.random(6);
        log.info("随机数为++++"+s+"           "+random);


    }

    @Bean
    public ApplicationListenerTest2 test2(){
        return  new ApplicationListenerTest2();
    }
}
