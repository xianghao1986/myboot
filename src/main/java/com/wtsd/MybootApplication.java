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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
//@EnableJms
@EnableCaching
public class MybootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MybootApplication.class, args);
		JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		final Map<String, String> map = new HashMap<String, String>();
		map.put("key1", "value1");
		map.put("key1", "value1");

		AtomicInteger atomicInteger = new AtomicInteger();

//		System.out.println("Sending an email message.");
//		jmsTemplate.convertAndSend("QL_TEST3",new Email("xianghao@nationz.com","你好"));
//		for (int i =0; i< 1; i++) {
//			executorService.execute(new Runnable() {
//				public void run() {
//					long t1 = System.currentTimeMillis();
//					jmsTemplate.convertAndSend("QL_TEST", "ok" );
//					Object obj = jmsTemplate.receiveAndConvert("QL_TEST2");
//					atomicInteger.incrementAndGet();
//					long t2 = System.currentTimeMillis();
//					System.err.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getId() + "耗时：" + (t2 - t1) + "ms");
//					System.err.println(obj);
//				}
//			});
//		}



//		jmsTemplate.convertAndSend(new Email("xianghao@nationz.com","你好"));
//		JedisPool pool = context.getBean(JedisPool.class);
//		Jedis jedis = pool.getResource();
//		jedis.set("test","你好");
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
