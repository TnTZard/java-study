package juc.cas;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.stream.IntStream;

/**
 * @Author: anzhi
 * @Date: 2020/12/25 16:42
 */
public class AtomicIntegerTest {

    private static AtomicInteger value = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            IntStream.range(0, 500).forEach(i -> value.getAndIncrement());
        });

        Thread thread2 = new Thread(() -> {
           IntStream.range(0, 500).forEach(i -> value.getAndIncrement());
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(value);
    }


}
