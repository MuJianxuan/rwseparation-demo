package org.rw.sharding.jdbc.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.hint.HintManager;
import org.rw.repository.entity.User;
import org.rw.repository.repository.UserRepository;
import org.rw.sharding.jdbc.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Rao
 * @Date 2021/4/17
 **/
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public User getUser(Long userId) {
        return userRepository.getById(userId);
    }

    /**
     * 1和2会负载访问，以组来访问，与定义的策略有关系
     * @param userId
     * @return
     */
    @Override
    public User getUser1(Long userId) {
        return userRepository.getById(userId);
    }

    @Override
    public User noAnoGetUser(Long userId) {
        return userRepository.getById(userId);
    }

    @Override
    public void updaeUser(User user) {

        user.setNickname("asdasd");
        boolean update = userRepository.updateById(user);
        System.out.println(update);

        //只有设置了这个值之后才会走主库

//        HintManager.getInstance().setMasterRouteOnly();

        User user1 = userRepository.getById(user.getId());
        log.info("更新后查询{}",user1);

    }

}
