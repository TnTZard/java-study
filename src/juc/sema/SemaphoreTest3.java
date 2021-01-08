package juc.sema;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Author: anzhi
 * @Date: 2020/12/25 11:10
 */
public class SemaphoreTest3 {

    public static void main(String[] args) {
        final Semaphore semaphore = new Semaphore(5);

        new Thread(() -> {
            System.out.println("availablePermits: " + semaphore.availablePermits());
            semaphore.drainPermits(); // 获取所有许可证
            System.out.println("availablePermits: " + semaphore.availablePermits());
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            semaphore.release(5);
            System.out.println(Thread.currentThread().getName() + "结束");
        }, "thread1").start();



    }

}
