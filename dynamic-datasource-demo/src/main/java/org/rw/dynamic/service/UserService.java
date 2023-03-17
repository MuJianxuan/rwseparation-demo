package org.rw.dynamic.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.rw.repository.entity.User;

/**
 * @author Rao
 * @Date 2021/4/17
 **/
public interface UserService {

    User getUser(Long userId);

    User getUser1(Long userId);

    User noAnoGetUser(Long userId);

}
