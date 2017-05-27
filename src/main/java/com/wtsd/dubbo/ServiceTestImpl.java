package com.wtsd.dubbo;

import org.springframework.stereotype.Service;

/**
 * Created by xianghao on 2017/5/26.
 */
@Service("serviceTestImpl")

public class ServiceTestImpl implements ServiceTest {
    public String test(String str) {
        System.out.println("hello world2");
        return "welcome to dubbo";
    }
}
