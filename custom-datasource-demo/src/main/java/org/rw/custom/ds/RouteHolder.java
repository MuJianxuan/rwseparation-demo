package org.rw.custom.ds;

/**
 * 1.0 版本太简陋，无法实现某些业务需求
 * @author Rao
 * @Date 2021/4/17
 **/
public class RouteHolder {

    private final static ThreadLocal<String> LOCAL_ROUTE = new ThreadLocal<String>();

    public static String get(){
        return LOCAL_ROUTE.get();
    }

    public static void set(String routeKey){
        LOCAL_ROUTE.set(routeKey);
    }

    public static void clear(){
        LOCAL_ROUTE.remove();
    }


}
