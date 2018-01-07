package jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by zhouyiwei on 2017/11/21.
 */
public class MyInvocationHandler implements InvocationHandler {

    //被代理对象
    private Object target;

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    //执行动态代理对象的所有方法，都会被替换成执行如下invoke方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        SpecailMethod sm = new SpecailMethod();
        sm.method1();
        //如果方法有返回值
        Object result = method.invoke(target,args);
        sm.method2();

        return result;
    }
}
