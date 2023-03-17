package org.rw.custom.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.rw.custom.ds.DataSourceEnum;
import org.rw.custom.ds.DataSourceRouter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 简单的方式
 * @author Rao
 * @Date 2021/4/17
 **/
@Configuration
public class CustomDataSourceConfig{


    /**
     * 主库
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource master() {
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * 从库 我吐了
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    public DataSource slaver() {
        return DruidDataSourceBuilder.create().build();
    }


    /**
     * 实例化数据源路由 Bean的名称
     */
    @Primary
    @Bean
    public DataSource dataSource(@Qualifier("master") DataSource masterDataSource,
                                             @Autowired(required = false) @Qualifier("slaver") DataSource slaveDataSource) {
        DataSourceRouter dynamicDataSource = new DataSourceRouter();
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put( DataSourceEnum.MASTER.getGroupName(), masterDataSource);
        if (slaveDataSource != null) {
            targetDataSources.put( DataSourceEnum.SLAVE.getGroupName(), slaveDataSource);
        }
        //设置所有数据源
        dynamicDataSource.setTargetDataSources(targetDataSources);
        //设置默认的数据源
        dynamicDataSource.setDefaultTargetDataSource(masterDataSource);

        return dynamicDataSource;
    }
}
