package com.example.demo;


import com.example.demo.User.ApplicationListenerTest2;
import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

import java.net.InetAddress;
//如果没有不想要数据库，可以加上排除数据库操作
//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@SpringBootApplication
@EnableScheduling
@MapperScan(basePackages = {"com.example.demo.mapper"})
public class DemoApplication {

    private final static Logger log = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) {



        log.info("我是springboot启动类------run 前 ----------");
        ConfigurableEnvironment environment = SpringApplication.run(DemoApplication.class, args).getEnvironment();
        String port = environment.getProperty("server.port");
        String status = environment.getProperty("server.status");
        String contextPath = environment.getProperty("server.servlet.context-path");
        String property = environment.getProperty("server.ssl.key-store");
        String hostAddress = null;
        try {
             hostAddress = InetAddress.getLocalHost().getHostAddress(); //获取本机ip地址
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("\n-----------------------------------------\n"+
            "host:{}"+"\taddress:{}"+"\tprofiles:{}"+
                "\n---------------------------------------------",
                port
                ,hostAddress,
                environment.getActiveProfiles()
                );


        log.info("测试git的dev分支！");
        log.info("我是springboot启动类------run 后 ----------");
        String s = RandomStringUtils.randomAlphanumeric(6);
        String random = RandomStringUtils.random(6);
        log.info("随机数为++++"+s+"           "+random);

    }

    //此处先把   --监容器加载完bean的事件监听注掉     因为本地没有redis集群会报错
    //@Bean
    public ApplicationListenerTest2 test2(){
        return  new ApplicationListenerTest2();
    }
}
