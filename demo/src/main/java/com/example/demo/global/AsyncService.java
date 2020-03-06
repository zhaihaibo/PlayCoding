package com.example.demo.global;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/*
@author  zhaihaibo
@data 2020/3/3 - 16:08
*/

//异步任务
@Service
public class AsyncService {

    @Async   //代表这个方法是异步的
    public void hello(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("---数据处理中-----");
    }


}
