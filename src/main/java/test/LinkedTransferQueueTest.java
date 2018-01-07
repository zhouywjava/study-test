package test;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/**
 * Created by zhouyiwei on 2017/7/22.
 */
public class LinkedTransferQueueTest {
    public static void main(String[] args) {
        TransferQueue<String> queue = new LinkedTransferQueue<String>();
        //启动生产者
        Thread producer = new Thread(new Producer(queue));
        producer.setDaemon(true);
        producer.start();
        //启动多个消费者
        for(int i = 0;i<10;i++){
            Thread consumer = new Thread(new Consumer(queue));
            consumer.setDaemon(true);
            consumer.start();
            try {
                Thread.sleep(1000);//主线程让出CPU
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
