package org.rw.custom.ds;

import org.springframework.core.NamedThreadLocal;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @author Rao
 * @Date 2021/4/18
 **/
public final class DsRouteHolder {

    private final static ThreadLocal<Deque<String>> LOOKUP_KEY_HOLDER = new NamedThreadLocal<Deque<String>>("Route_Datasource"){
        @Override
        protected Deque<String> initialValue() {
            return new ArrayDeque<>();
        }
    };


    private DsRouteHolder(){}

    public static String get(){
        //查看头部
        return LOOKUP_KEY_HOLDER.get().peek();
    }

    public static void set(String routeKey){
        //添加到头部
        LOOKUP_KEY_HOLDER.get().push(routeKey);
    }

    public static void clear(){
        Deque<String> deque = LOOKUP_KEY_HOLDER.get();
        if(deque.isEmpty()){
            LOOKUP_KEY_HOLDER.remove();
        }
        deque.poll();
    }

}
