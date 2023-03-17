package org.rw.dynamic.config;

import com.baomidou.dynamic.datasource.plugin.MasterSlaveAutoRoutingPlugin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Rao
 * @Date 2021/4/17
 **/
@Configuration
public class DynamicDataSourceConfig {
    /**
     * 自动读写分离插件
     * @return
     */
    @Bean
    public MasterSlaveAutoRoutingPlugin masterSlaveAutoRoutingPlugin(){
        return new MasterSlaveAutoRoutingPlugin();
    }
}
