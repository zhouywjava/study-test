package QueueTest;

import java.time.LocalDate;
import java.util.PriorityQueue;

/**
 * Created by zhouyiwei on 2018/2/22.
 */
public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue<LocalDate> pq = new PriorityQueue<>();
        pq.add(LocalDate.of(1906,12,9));
        pq.add(LocalDate.of(1815,12,10));
        pq.add(LocalDate.of(1903,12,3));
        pq.add(LocalDate.of(1910,6,22));

        System.out.println("========start ===============");
        for(LocalDate date : pq){
            System.out.println(date);
        }

        System.out.println("========start remove===============");
        while(!pq.isEmpty()){
            System.out.println(pq.remove());
        }
    }
}
