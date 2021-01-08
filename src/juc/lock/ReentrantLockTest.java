package juc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * @Author: anzhi
 * @Date: 2020/12/28 9:56
 */
public class ReentrantLockTest {

    // ReentrantLock 可重入锁 （又称为递归锁）
    // 表示该锁能够支持一个线程对资源的重复加锁

    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        IntStream.range(0, 2).forEach(i -> new Thread(ReentrantLockTest::needLock).start());
    }

    public static void needLock() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "开始工作");
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }



    public static void needLockBySync() {
        synchronized (ReentrantLockTest.class) {
            try {
                System.out.println(Thread.currentThread().getName() + "开始工作");
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
