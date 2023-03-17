package org.rw.custom.ds;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 自定义路由数据源
 * @author Rao
 * @Date 2021/4/17
 **/
public class DataSourceRouter extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return RouteHolder.get();
    }
}
