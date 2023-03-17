package org.rw.repository.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Rao
 * @Date 2021/4/17
 **/
@Data
@TableName("t_user")
public class User {

    @TableId
    private Long id;

    private String nickname;

    private String password;

    private Integer age;

    private Integer sex;

    private String birthday;

}
