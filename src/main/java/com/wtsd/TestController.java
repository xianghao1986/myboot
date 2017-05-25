package com.wtsd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xianghao on 2017/5/25.
 */
@RestController
public class TestController {

    private @Autowired PersonConfig config;

    private @Autowired UserRepository userRepository;
    @RequestMapping(value = "/test")
    public String test() {
        return config.getName() + ":"+config.getAge();
    }

    @RequestMapping(value = "user/add", method = RequestMethod.GET)
    public String add(@RequestParam(value = "name" ,defaultValue = "") String name, @RequestParam String email){
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        userRepository.save(user);
        return "保存成功";
    }
}
