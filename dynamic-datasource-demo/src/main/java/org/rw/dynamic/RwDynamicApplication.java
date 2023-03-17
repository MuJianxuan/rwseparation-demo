package org.rw.dynamic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Rao
 * @Date 2021/4/11
 **/
@SpringBootApplication(scanBasePackages = {"org.rw"})
@MapperScan("org.rw.repository.dao")
public class RwDynamicApplication {

    public static void main(String[] args) {
        SpringApplication.run(RwDynamicApplication.class,args);
    }

}
