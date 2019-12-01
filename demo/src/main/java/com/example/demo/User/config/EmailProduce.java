package com.example.demo.User.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingDeque;



public class EmailProduce implements  Runnable {

    private Logger log = LoggerFactory.getLogger(EmailProduce.class);

    private BlockingDeque queue;  //双端阻塞队列

    private Email email;

    public EmailProduce(BlockingDeque queue) {
        this.queue = queue;
    }


    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    @Override
    public void run() {

        log.info("将"+email+"放入阻塞队列-----------------------");


        try {
            queue.put(email);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
