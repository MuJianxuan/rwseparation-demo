package org.rw.dynamic.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.support.DdConstants;
import org.rw.dynamic.service.UserService;
import org.rw.repository.entity.User;
import org.rw.repository.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Rao
 * @Date 2021/4/17
 **/
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @DS(DdConstants.MASTER)
    @Override
    public User getUser(Long userId) {
        return userRepository.getById(userId);
    }

    /**
     * 1和2会负载访问，以组来访问，与定义的策略有关系
     * @param userId
     * @return
     */
    @DS(DdConstants.SLAVE)
    @Override
    public User getUser1(Long userId) {
        return userRepository.getById(userId);
    }

    @Override
    public User noAnoGetUser(Long userId) {
        return userRepository.getById(userId);
    }

}
