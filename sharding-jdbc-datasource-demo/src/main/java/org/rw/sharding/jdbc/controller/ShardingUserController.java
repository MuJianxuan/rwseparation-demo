package org.rw.sharding.jdbc.controller;

import org.rw.repository.dao.UserDao;
import org.rw.repository.entity.User;
import org.rw.repository.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @author Rao
 * @Date 2021/11/09
 **/
@RequestMapping("/sharding-user")
@RestController
public class ShardingUserController {

    @Resource
    private UserRepository userRepository;


    /**
     * sex:奇数
     * age:奇数
     * ds1.t_user1
     */
    @PostMapping("test01")
    public void test01() {
        User user = new User();
        user.setNickname("zhangsan" + new Random().nextInt());
        user.setPassword("123456");
        user.setAge(17);
        user.setSex(1);
        user.setBirthday("1997-12-03");
        userRepository.save(user);
    }

    /**
     * sex:奇数
     * age:偶数
     * ds1.t_user0
     */
    @PostMapping("test02")
    public void test02() {
        User user = new User();
        user.setNickname("zhangsan" + new Random().nextInt());
        user.setPassword("123456");
        user.setAge(18);
        user.setSex(1);
        user.setBirthday("1997-12-03");
        userRepository.save(user);
    }

    /**
     * sex:偶数
     * age:奇数
     * ds0.t_user1
     */
    @PostMapping("test03")
    public void test03() {
        User user = new User();
        user.setNickname("zhangsan" + new Random().nextInt());
        user.setPassword("123456");
        user.setAge(17);
        user.setSex(2);
        user.setBirthday("1997-12-03");
        userRepository.save(user);
    }

    /**
     * sex:偶数
     * age:偶数
     * ds0.t_user0
     */
    @PostMapping("test04")
    public void test04() {
        User user = new User();
        user.setNickname("zhangsan" + new Random().nextInt());
        user.setPassword("123456");
        user.setAge(18);
        user.setSex(2);
        user.setBirthday("1997-12-03");
        userRepository.save(user);
    }

    @GetMapping("/getById")
    public User getById(){
        // 这怎么找数据呢？
        return userRepository.getById( 664878738453823489L);
    }

}
