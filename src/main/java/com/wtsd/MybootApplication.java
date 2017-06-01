package com.wtsd;

import com.wtsd.jms.Email;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
//@EnableJms
@EnableCaching
public class MybootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MybootApplication.class, args);
//		JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
//		System.out.println("Sending an email message.");
//		jmsTemplate.convertAndSend(new Email("xianghao@nationz.com","你好"));
		JedisPool pool = context.getBean(JedisPool.class);
		Jedis jedis = pool.getResource();
		jedis.set("test","你好");
//		System.err.println(jedis.get("test"));

//		RedisTemplate redisTemplate = context.getBean(RedisTemplate.class);
	}

	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		CorsFilter myFilter = new CorsFilter();
		registrationBean.setFilter(myFilter);
		List<String> urlPatterns = new ArrayList<String>();
		urlPatterns.add("/*");
		registrationBean.setUrlPatterns(urlPatterns);
		return registrationBean;
	}
}
