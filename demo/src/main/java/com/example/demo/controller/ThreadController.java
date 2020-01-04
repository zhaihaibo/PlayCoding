package com.example.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolExecutorFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;


@Controller
public class ThreadController {

    private Logger logger = LoggerFactory.getLogger(ThreadController.class);

    @RequestMapping("/thread/replace/for")
    @ResponseBody
    public String ThreadReplaceFor() throws Exception {


        List<Integer> list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        long l1 = System.currentTimeMillis();
        for (Integer o : list) {
            Object o1 = list.get(o);
            Thread.sleep(500); //模拟耗时操作！
            System.out.println(o1 + " " + Thread.currentThread().getName());
        }
        AtomicInteger atomicInteger = new AtomicInteger(100);

        Integer i1 = 200;
        Integer i2 = 200;
        boolean b=  i1==i2;
        logger.info("Integer 100 == Integer 100 true or false? ================>" +b);

        long l2 = System.currentTimeMillis();
        System.out.println("使用for循环消耗的时间是------------》：" + (l2 - l1));


        long l3 = System.currentTimeMillis();
//ThreadPoolTaskExecutor是spring.core包下的，是spring对JUC的ThreadPoolExecutor进行的一次封装
//        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//        executor.setCorePoolSize(5);
//        executor.setMaxPoolSize(10);
//        executor.setAllowCoreThreadTimeOut(true); //*指定是否允许核心线程超时。这支持动态增长和收缩，甚至与非零队列结合使用(因为最大池大小只在队列满时才会增长)。
//        executor.setQueueCapacity(20);
//        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
//        executor.initialize();


//newFixedThreadPool线程池的队列中没有指定大小，为无界链表阻塞队列，当线程无限往队列中添加是会有OOM异常
//        ExecutorService executor = Executors.newFixedThreadPool(10);

        //使用自定义线程池的作用就是为了防止oom异常  ，其他四种可能会又oom
        ExecutorService executor = new ThreadPoolExecutor(10,
                10,
                60L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(1000),
                new ThreadPoolExecutorFactoryBean(),
                new ThreadPoolExecutor.AbortPolicy());


        for (int i = 0; i < list.size(); i++) {
            Integer integer = list.get(i);

            Runnable runnable = new Runnable() {

                @Override
                public void run() {
                    try {
                        Thread.sleep(500); //模拟耗时操作！
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(integer + " " + Thread.currentThread().getName());
                }
            };
            executor.execute(runnable);
        }
        executor.shutdown();
        while (true) {
            if (executor.isTerminated()) {
                System.out.println("结束了！");
                long l4 = System.currentTimeMillis();
                System.out.println("使用线程池的操作时间是：----------》" + (l4 - l3));
                break;
            }
        }
            return "1";
        }

}
