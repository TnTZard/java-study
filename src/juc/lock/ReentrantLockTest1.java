package juc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: anzhi
 * @Date: 2020/12/28 11:37
 */
public class ReentrantLockTest1 {
    private static final ReentrantLock lock = new ReentrantLock();



    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(ReentrantLockTest1::testLockUnInterruptibly2, "thread1");
        thread1.start();
        TimeUnit.SECONDS.sleep(1);

        Thread thread2 = new Thread(ReentrantLockTest1::testLockUnInterruptibly2, "thread2");
        thread2.start();
        TimeUnit.SECONDS.sleep(1);

        thread2.interrupt();
    }

    public static void testLockUnInterruptibly() {
     try {
         lock.lock();
         System.out.println(Thread.currentThread().getName() + "开始工作");
         while (true) { }
     } finally {
         lock.unlock();
     }
    }

    public static void testLockUnInterruptibly2() {
     try {
         lock.lockInterruptibly(); // 可以被打断
         System.out.println(Thread.currentThread().getName() + "开始工作");
         while (true) { }
     } catch (InterruptedException e) {
         e.printStackTrace();
     } finally {
         lock.unlock();
     }
    }

}
