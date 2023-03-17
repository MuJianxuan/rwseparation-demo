package org.rw.custom;

//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author Rao
 * @Date 2021/4/11
 **/
@SpringBootApplication(scanBasePackages = {"org.rw"},exclude = DataSourceAutoConfiguration.class)
//@MapperScan(value = "org.rw.repository.dao")
public class CustomDatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomDatasourceApplication.class,args);
    }

}
