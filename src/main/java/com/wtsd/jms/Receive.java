package com.wtsd.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by xianghao on 2017/6/1.
 */
@Component
public class Receive {

    private @Autowired
    JmsTemplate jmsTemplate;

    @JmsListener(destination = "${jms.listen.dest}", containerFactory = "myFactory")
    public void receiveMessage(Email obj) {
        System.out.println("Received <" + obj + ">");
    }

    @JmsListener(destination = "mailbox2", containerFactory = "myFactory",concurrency = "100" )
    public void receiveMessage2(Object obj) {
        System.out.println("Received <" + obj + ">");
    }

    @JmsListener(destination = "QL_TEST", containerFactory = "myFactory")
    public void receiveMessage3(Object obj) {
        jmsTemplate.convertAndSend("QL_TEST2", obj);
    }
//    @JmsListener(destination = "QL_TEST2", containerFactory = "myFactory")
//    public void receiveMessage4(Object obj) {
//        long t1 = System.currentTimeMillis();
//        long t2 = System.currentTimeMillis();
//        System.err.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getId()+  "耗时："+ (t2 -t1) +"ms");
//
//    }



}
