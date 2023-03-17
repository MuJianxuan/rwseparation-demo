package org.rw.custom.core;

import org.rw.custom.ds.DataSourceEnum;

import java.lang.annotation.*;

/**
 * @author Rao
 * @Date 2021/4/18
 **/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.METHOD})
public @interface DS {

    DataSourceEnum value() default DataSourceEnum.MASTER;

}
