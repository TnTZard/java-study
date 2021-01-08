package juc.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author: anzhi
 * @Date: 2020/12/25 18:28
 */
public class AtomicIntegerTest3 {

    public static void main(String[] args) {
        AtomicReference<String> atomicReference = new AtomicReference<>("A");
        new Thread(() -> {
            // 模拟一次ABA操作
            atomicReference.compareAndSet("A", "B");
            atomicReference.compareAndSet("B", "A");
            System.out.println(Thread.currentThread().getName() + "线程完成了一次ABA操作");
        }, "thread1").start();

        new Thread(() -> {
            // 让thread2先睡眠2秒钟，确保thread1的ABA操作完成
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean result = atomicReference.compareAndSet("A", "B");
            if (result) {
                System.out.println(Thread.currentThread().getName() + "线程修改值成功，当前值为：" + atomicReference.get());
            }
        }, "thread2").start();
    }

}
