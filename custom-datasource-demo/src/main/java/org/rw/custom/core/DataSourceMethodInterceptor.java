package org.rw.custom.core;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.rw.custom.ds.DataSourceEnum;
import org.rw.custom.ds.RouteHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;

/**
 * @author Rao
 * @Date 2021/4/18
 **/
@Component
@Aspect
public class DataSourceMethodInterceptor {

    @Around("@annotation(DS)")
    public Object doBeginRoute(ProceedingJoinPoint pjp) throws Throwable {
        try {
            MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
            Method method = methodSignature.getMethod();
            DS ds = method.getAnnotation(DS.class);
            Transactional transactional = method.getAnnotation(Transactional.class);
            if(ds != null){
                RouteHolder.set(ds.value().getGroupName());
            }else if(transactional.readOnly()){
                RouteHolder.set(DataSourceEnum.SLAVE.getGroupName());
            }
            return pjp.proceed();
        }finally {
            RouteHolder.clear();
        }
    }
}
