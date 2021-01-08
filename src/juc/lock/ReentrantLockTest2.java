package juc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: anzhi
 * @Date: 2020/12/28 18:10
 */
public class ReentrantLockTest2 {

    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(ReentrantLockTest2::testTryLock, "thread1");
        thread1.start();
        TimeUnit.SECONDS.sleep(1);

        Thread thread2 = new Thread(ReentrantLockTest2::testTryLock, "thread2");
        thread2.start();
        /**
         * thread1 抢到锁之后进入死循环，一直不释放锁
         * thread2 尝试获取锁失败后直接放弃
         */
    }

    public static void testTryLock() {
        if (lock.tryLock()) {
            try {
                System.out.println(Thread.currentThread().getName() + "开始工作");
                while (true) {

                }
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + "没有获取到锁");
        }
    }




}
