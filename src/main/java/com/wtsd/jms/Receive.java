package com.wtsd.jms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by xianghao on 2017/6/1.
 */
//@Component
public class Receive {

    @JmsListener(destination = "${jms.listen.dest}", containerFactory = "myFactory")
    public void receiveMessage(Email obj) {
        System.out.println("Received <" + obj + ">");
    }

    @JmsListener(destination = "mailbox2", containerFactory = "myFactory")
    public void receiveMessage2(Object obj) {
        System.out.println("Received <" + obj + ">");
    }

}
