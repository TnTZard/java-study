package juc.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @Author: anzhi
 * @Date: 2020/12/24 16:40
 */
public class CyclicBarrierTest3 {

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(2);
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread() + "开始执行");
                TimeUnit.SECONDS.sleep(3);
                barrier.await();
                System.out.println(Thread.currentThread() + "继续执行");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }, "thread1").start();

        Thread thread2 = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread() + "开始执行");
                TimeUnit.SECONDS.sleep(1);
                barrier.await();
                System.out.println(Thread.currentThread() + "继续执行");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }, "thread2");

        thread2.start();
        TimeUnit.SECONDS.sleep(2);
        thread2.interrupt();
    }

}
