package org.rw.repository.repository.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.rw.repository.dao.UserDao;
import org.rw.repository.entity.User;
import org.rw.repository.repository.UserRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Rao
 * @Date 2021/4/17
 **/
@Repository
public class UserRepositoryImpl extends ServiceImpl<UserDao,User> implements UserRepository {
}
