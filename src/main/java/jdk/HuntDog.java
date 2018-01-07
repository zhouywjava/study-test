package jdk;

/**
 * Created by zhouyiwei on 2017/11/21.
 */
public class HuntDog implements Dog {
    @Override
    public void info() {
        System.out.println("我是一只猎狗");
    }

    @Override
    public void run() {
        System.out.println("我跑的很快");
    }
}
