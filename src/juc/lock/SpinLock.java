package juc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author: anzhi
 * @Date: 2020/12/28 18:19
 */
public class SpinLock {

    AtomicReference<Thread> reference = new AtomicReference<>();

    public void lock() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "尝试获取锁");
        while (!reference.compareAndSet(null, thread)) {
            // 自旋锁就是利用CAS思想制造循环，block住代码
        }
        System.out.println(thread.getName() + "获取到了锁");
    }

    public void unlock() {
        Thread thread = Thread.currentThread();
        reference.compareAndSet(thread, null);
        System.out.println(thread.getName() + "释放锁");
    }

    public static void main(String[] args) {
        SpinLock lock = new SpinLock();
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "做某事...");
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "线程1").start();

        new Thread(() -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "做某事...");
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "线程2").start();

    }

}
