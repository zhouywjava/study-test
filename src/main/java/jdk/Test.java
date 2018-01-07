package jdk;

/**
 * Created by zhouyiwei on 2017/11/21.
 */
public class Test {
    public static void main(String[] args) {
        Dog dog = new HuntDog();
        dog.info();
        dog.run();
        System.out.println("=========================================");
        Dog proxy = (Dog) MyInvocationHandlerFactory.getProxy(dog);
        proxy.info();
        proxy.run();
    }
}
