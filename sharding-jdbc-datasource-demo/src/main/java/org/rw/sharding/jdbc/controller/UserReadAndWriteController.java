package org.rw.sharding.jdbc.controller;

import lombok.extern.slf4j.Slf4j;
import org.rw.repository.dao.UserDao;
import org.rw.repository.entity.User;
import org.rw.sharding.jdbc.service.UserService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 读写分离
 * @author Rao
 * @Date 2021/4/17
 **/
@Slf4j
@RestController
@RequestMapping("read-write")
public class UserReadAndWriteController {

    @Resource
    private UserService userService;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id")Long userId){

//        User user = userService.noAnoGetUser(userId);
//        log.info("noAnoGetUser:{}",user);
//
//        userService.updaeUser(user);

        User user1 = userService.getUser1(userId);
        log.info("getUser1:{}",user1);

        return userService.noAnoGetUser(userId);
    }

}
