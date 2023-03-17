package org.rw.dynamic.controller;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.support.DdConstants;
import lombok.extern.slf4j.Slf4j;
import org.rw.dynamic.service.UserService;
import org.rw.repository.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Rao
 * @Date 2021/4/17
 **/
@Slf4j
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @DS(DdConstants.MASTER)
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id")Long userId){

        User user = userService.noAnoGetUser(userId);
        log.info("noAnoGetUser:{}",user);

        User user1 = userService.getUser1(userId);
        log.info("getUser1:{}",user1);

        return userService.noAnoGetUser(userId);
    }

}
