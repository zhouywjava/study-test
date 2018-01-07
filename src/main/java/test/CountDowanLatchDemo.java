package test;

import java.util.concurrent.CountDownLatch;

/**
 * Created by zhouyiwei on 2017/7/22.
 */
public class CountDowanLatchDemo {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);
        for(int i = 0;i<3;i++){
            new Worker("程序员"+i ,latch).start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main thread end" );

    }
}
