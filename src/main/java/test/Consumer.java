package test;

import java.util.concurrent.TransferQueue;

/**
 * Created by zhouyiwei on 2017/7/22.
 */
public class Consumer implements Runnable{
    private final TransferQueue<String> queue;
    public Consumer(TransferQueue<String> queue){
        this.queue = queue;
    }

    public void run() {
        try {
            System.out.println(" Consumer "+ Thread.currentThread().getName() + queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
