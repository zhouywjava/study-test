package jdk;

import java.lang.reflect.Proxy;

/**
 * Created by zhouyiwei on 2017/11/21.
 */
public class MyInvocationHandlerFactory {

    public static Object getProxy(Object target){
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.setTarget(target);
        //被代理类加载器，代理类所有的接口实现，代理处理器
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),handler);
    }
}
