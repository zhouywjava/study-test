package test;

import java.util.concurrent.CountDownLatch;

/**
 * Created by zhouyiwei on 2017/7/22.
 */
public class Worker extends Thread {
    private String name;
    private CountDownLatch latch;
    public Worker(String name,CountDownLatch latch){
        this.name = name;
        this.latch = latch;
    }
    public void run(){
        System.out.println("worker: "+name+" is begining");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("worker: "+name+" is ending");
        latch.countDown();
    }
}
