package org.rw.sharding.jdbc.service;

import org.rw.repository.entity.User;

/**
 * @author Rao
 * @Date 2021/4/17
 **/
public interface UserService {

    User getUser(Long userId);

    User getUser1(Long userId);

    User noAnoGetUser(Long userId);

    void updaeUser(User user);
}
