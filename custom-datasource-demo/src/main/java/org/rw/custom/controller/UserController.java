package org.rw.custom.controller;

import lombok.extern.slf4j.Slf4j;
import org.rw.custom.core.DS;
import org.rw.custom.ds.DataSourceEnum;
//import org.rw.repository.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author Rao
 * @Date 2021/4/17
 **/
@Slf4j
@RestController
public class UserController {

    @Resource
    private JdbcTemplate jdbcTemplate;


    @DS(DataSourceEnum.SLAVE)
    @GetMapping("/user/{id}")
    public List<Map<String, Object>> getUser(@PathVariable("id")Long userId){

//        User user = userService.noAnoGetUser(userId);
//        log.info("noAnoGetUser:{}",user);
//
//        User user1 = userService.getUser1(userId);
//        log.info("getUser1:{}",user1);
//
//        return userService.noAnoGetUser(userId);

        String sql = "select * from user";

        return jdbcTemplate.queryForList(sql);

    }

    @DS(DataSourceEnum.MASTER)
    @GetMapping("/slave/{id}")
    public List<Map<String, Object>> testSlave(@PathVariable("id")Long userId){

        String sql = "select * from user";

        return jdbcTemplate.queryForList(sql);

    }

}
