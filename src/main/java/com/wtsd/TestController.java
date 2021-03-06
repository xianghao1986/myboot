package com.wtsd;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import com.wtsd.entity.PointsDetail;
import com.wtsd.repository.PointsDetailRepository;
import com.wtsd.serivce.UserService;

/**
 *
 * Created by xianghao on 2017/5/25.
 */
@RestController
public class TestController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


	private @Autowired PersonProperties config;

	private @Autowired
    UserService userService;
	private @Autowired
    PointsDetailRepository pointsDetailRepository;


	@RequestMapping(value = "/test")
	public String test() {
		return config.getName() + ":" + config.getAge();
	}

	@PostMapping(value = "/user")
	public Object create(
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "email", defaultValue = "") String email) {
        System.err.println("收到POST 请求 ");
		User user = new User();
		user.setEmail(email);
		user.setName(name);
        userService.save(user);
        Result result = new Result();

		return new Result("save success");
	}


	@GetMapping(value = "/user")
    public Object findList(){
	    return new Result(userService.findAll());
    }
    @GetMapping(value = "/user/{id}")
    public Object findOne(@PathVariable("id") Integer id){
        return new Result(userService.findOne(id));
    }
    @PutMapping(value = "/user/{id}")
    public Object update(@PathVariable("id") Integer id, @RequestParam("name") String name, @RequestParam("email") String email){
        System.err.println("收到update 请求 id:"+ id);
        User user = new User();
        user.setId(id);
        user.setEmail(email);
        user.setName(name);
        userService.save(user);
        return new Result("success");
    }

    @DeleteMapping(value = "/user/{id}")
    public Object delete(@PathVariable("id") Integer id){
        System.err.println("收到detele 请求 id:"+ id);
        userService.delete(id);
        return new Result("success");
    }

    @RequestMapping(value = "*", method = RequestMethod.OPTIONS)
    public Object options(){
        System.err.println("收到options请求，返回allow");
        return new Result("allow");
    }

	@GetMapping(value = "/pointsDetail")
	public Object queryList(String pageNum, String pageSize) {
		Pageable pageable = new PageRequest(Integer.parseInt(pageNum),
				Integer.parseInt(pageSize), new Sort(Sort.Direction.DESC,
						"recordTime"));
		Page<PointsDetail> page = pointsDetailRepository.findAll(pageable);
		long total = page.getTotalElements();
		int totalPages = page.getTotalPages();
		List<PointsDetail> list = page.getContent();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("totalPages", totalPages);
		map.put("list", list);
		return map;
	}


}
