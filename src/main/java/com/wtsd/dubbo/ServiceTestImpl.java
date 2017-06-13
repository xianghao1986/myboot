package com.wtsd.dubbo;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by xianghao on 2017/5/26.
 */
@Service("serviceTestImpl")
public class ServiceTestImpl implements ServiceTest {
    public String test(String str) {
        System.err.println("收到请求");
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.err.println("响应成功");
        return str;
    }

    @Override
    public void noRespTest(String str) throws InterruptedException {
        long t1 = System.currentTimeMillis();
        System.err.println("收到远程调用："+ str);
//        System.err.println("go to sleep....");
//        Thread.sleep(500);
        long t2 = System.currentTimeMillis();
        System.err.println(System.currentTimeMillis());

    }

    @Override
    public Map<String, String> test2(Map<String, String> map) {
       return map;
    }


}
