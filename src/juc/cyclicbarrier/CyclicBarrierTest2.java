package juc.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @Author: anzhi
 * @Date: 2020/12/24 16:18
 */
public class CyclicBarrierTest2 {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(2, new Thread(() -> {
            System.out.println("发车，嘟嘟嘟");
        }));

        System.out.println("快上车来不及解释了");

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread() + "已上车");
                barrier.await();
                System.out.println("所有人已上车，发车");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }, "Jane").start();


        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread() + "已上车");
                barrier.await();
                System.out.println("所有人已上车，发车");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }, "Mike").start();


    }




}
