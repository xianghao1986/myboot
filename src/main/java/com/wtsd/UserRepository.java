package com.wtsd;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.QueryHint;

/**
 * Created by xianghao on 2017/5/25.
 *
 */
public interface UserRepository extends CrudRepository<User, Integer> {
    @QueryHints({@QueryHint(name = "org.hibernate.cacheable",value = "true")})
    User findOne(int id);
}
