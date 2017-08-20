package com.wtsd.serivce;

import javax.transaction.Transactional;

import com.wtsd.UserRepository;
import com.wtsd.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by xianghao on 2017/6/1.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private @Autowired
	UserRepository userRepository;

	@Override
    @Cacheable(value = "userCache",keyGenerator = "keyGenerator")
	public Iterable findAll() {
        logger.debug("findAll....");
		return userRepository.findAll();
	}

	@CacheEvict()
	public Iterable clearfindAll() {
		logger.debug("clearAll....");
		return userRepository.findAll();
	}

	@Override
    @Cacheable(value = "userCache1", keyGenerator = "keyGenerator")
	public User findOne(Integer id) {
	    logger.debug("findOne...");
		return userRepository.findOne(id);
	}

	@Override
	@CacheEvict(value= "userCache", key = "T(String).valueOf(#id)")
	public void delete(Integer id) {
		logger.debug("delete....");
		clearfindAll();
		userRepository.delete(id);
	}

	@Override
	@CachePut(cacheNames = "userCache", key = "T(String).valueOf(#user.id)")
	public void save(User user) {
		logger.debug("save....");
		clearfindAll();
		userRepository.save(user);
	}
}
