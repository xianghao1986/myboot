package com.wtsd;

/**
 * Created by xianghao on 2017/6/1.
 */
public interface UserService {
    Iterable findAll();
    User findOne(Integer id);

    void delete(Integer id);

    void save(User user);


}
