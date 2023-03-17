package org.rw.custom.service.impl;

import org.rw.custom.core.DS;
import org.rw.custom.ds.DataSourceEnum;
import org.rw.custom.service.UserService;
//import org.rw.repository.entity.User;
//import org.rw.repository.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Rao
 * @Date 2021/4/17
 **/
@Service
public class UserServiceImpl implements UserService {

//    @Resource
//    private UserRepository userRepository;
//
//    @Override
//    public User getUser(Long userId) {
//        return userRepository.getById(userId);
//    }
//
//    /**
//     * 1和2会负载访问，以组来访问，与定义的策略有关系
//     * @param userId
//     * @return
//     */
//    @DS(DataSourceEnum.SLAVE)
//    @Override
//    public User getUser1(Long userId) {
//        return userRepository.getById(userId);
//    }
//
//    @Override
//    public User noAnoGetUser(Long userId) {
//        return userRepository.getById(userId);
//    }

}
