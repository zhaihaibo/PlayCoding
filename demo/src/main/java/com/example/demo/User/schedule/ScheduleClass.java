package com.example.demo.User.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ScheduleClass {

    private Logger log =  LoggerFactory.getLogger(ScheduleClass.class);

    @Scheduled(cron = "*/50 * * * * ?")
    public void push() {
        Date startDate = new Date();
        log.info("定时器执行任务开始+++++"+startDate);

    }

}
