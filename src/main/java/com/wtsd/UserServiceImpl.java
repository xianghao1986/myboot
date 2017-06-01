package com.wtsd;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by xianghao on 2017/6/1.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private @Autowired UserRepository userRepository;

	@Override
    @Cacheable("user")
	public Iterable findAll() {
        logger.debug("findAll....");
		return userRepository.findAll();
	}

	@Override
    @Cacheable("user")
	public User findOne(Integer id) {
	    logger.debug("findOne...");
		return userRepository.findOne(id);
	}

	@Override
	public void delete(Integer id) {
		userRepository.delete(id);
	}

	@Override
	@CacheEvict("user")
	public void save(User user) {
		userRepository.save(user);
	}
}
