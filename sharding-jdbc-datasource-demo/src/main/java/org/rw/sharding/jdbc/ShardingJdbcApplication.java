package org.rw.sharding.jdbc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 读写分离
 * @author Rao
 * @Date 2021/4/19
 **/
@SpringBootApplication(scanBasePackages = {"org.rw"})
@MapperScan("org.rw.repository.dao")
public class ShardingJdbcApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShardingJdbcApplication.class,args);
    }
}
