package com.wtsd.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;

/**
 * Created by xianghao on 2017/6/1.
 */
@Configuration
public class RedisCacheConfiguration extends CachingConfigurerSupport {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;


    @Bean
    public JedisPool redisPoolFactory() {
        logger.info("JedisPool注入成功！！");
        logger.info("redis地址：" + host + ":" + port);
        JedisPool jedisPool = new JedisPool(host, port);

        return jedisPool;
    }
}
