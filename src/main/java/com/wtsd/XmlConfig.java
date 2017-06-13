package com.wtsd;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import javax.annotation.PostConstruct;

/**
 * Created by xianghao on 2017/5/26.
 */
//@Configuration
//@ImportResource(locations={"classpath:dubbo-provider.xml"})
public class XmlConfig {

    @PostConstruct
    public void init(){
        System.err.println("Init...");
    }
}
