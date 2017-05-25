package com.wtsd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xianghao on 2017/5/25.
 */
@RestController
public class TestController {

    private @Autowired PersonConfig config;

    @RequestMapping(value = "/test")
    public String test() {
        return config.getName() + ":"+config.getAge();
    }
}
