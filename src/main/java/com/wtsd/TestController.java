package com.wtsd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * Created by xianghao on 2017/5/25.
 */
@RestController
public class TestController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


	private @Autowired PersonProperties config;

	private @Autowired UserRepository userRepository;

	@RequestMapping(value = "/test")
	public String test() {
		return config.getName() + ":" + config.getAge();
	}

	@PostMapping(value = "/user")
	public String create(
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "email", defaultValue = "") String email) {
		User user = new User();
		user.setEmail(email);
		user.setName(name);
		userRepository.save(user);
		return "保存成功";
	}


	@GetMapping(value = "/user")
    public Object findList(){
	    return userRepository.findAll();
    }
    @GetMapping(value = "/user/{id}")
    public Object findOne(@PathVariable("id") Integer id){
        return userRepository.findOne(id);
    }
    @PutMapping(value = "/user/{id}")
    public Object update(@PathVariable("id") Integer id, @RequestParam("name") String name, @RequestParam("email") String email){
        User user = new User();
        user.setId(id);
        user.setEmail(email);
        user.setName(name);
        userRepository.save(user);
        return "success";
    }

    @DeleteMapping(value = "/user/{id}")
    public Object delete(@PathVariable("id") Integer id){
        userRepository.delete(id);
        return "success";
    }
}
