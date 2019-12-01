package com.example.demo.User.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;


@Component
@EnableAsync
public class ThreadConfig implements AsyncConfigurer {

   private   Logger log =  LoggerFactory.getLogger(ThreadConfig.class);

   //线程池
    @Bean
   public  Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setAllowCoreThreadTimeOut(true); //*指定是否允许核心线程超时。这支持动态增长和收缩，甚至与非零队列结合使用(因为最大池大小只在队列满时才会增长)。
        executor.setQueueCapacity(20);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        executor.initialize();
        log.info("线程池已启动------++");
        return  executor;
    }

    /*异步任务中异常处理*/
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {

        return new SimpleAsyncUncaughtExceptionHandler();
    }

    //初始化生产者线程
    @Bean
    public EmailProduce getProduce(){
        return  new EmailProduce(new LinkedBlockingDeque());
    }

}
