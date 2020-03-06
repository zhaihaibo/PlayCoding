package com.example.demo.global;

/*
@author  zhaihaibo
@data 2020/3/3 - 16:20
*/

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

//定时任务
@Service
public class ScheduledService {

//    @Scheduled(cron = "0-4 * * * * MON-SAT")  //每分钟从0-4秒之间执行

//    【0 0/5 14,18 * * ? 】 每天下午2点，4点每隔5分钟执行一次
//    【0 15 10 ? * 1-6 】 每个月周一至周六10：15分执行一次
//    【0 0 2 ? * 6L】 每个月最后一个周六凌晨两点执行一次
//    【0 0 2 LW *  ? 】 每个月最后一个工作日凌晨两点执行一次
    @Scheduled(cron = "0/1000 * * * * MON-SAT")  //每1000秒执行一次
    public void hello(){
        System.out.println("----处理定时任务-----");
    }


}
