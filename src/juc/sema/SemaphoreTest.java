package juc.sema;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @Author: anzhi
 * @Date: 2020/12/25 10:54
 */
public class SemaphoreTest {

    public static void main(String[] args) {

        /**
         * JUC的Semaphore俗称信号量
         * 用来控制同时访问特定资源的线程数量
         */

        // 定义许可证数量
        final Semaphore semaphore = new Semaphore(2);

        IntStream.range(0, 4).forEach(i -> {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "开始");
                try {
                    semaphore.acquire(); // 一次拿一个许可证
                    System.out.println(Thread.currentThread().getName() + "获取许可证");
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(Thread.currentThread().getName() + "释放许可证");
                    semaphore.release();
                }
                System.out.println(Thread.currentThread().getName() + "结束");
            }, "thread" + (i + 1)).start();
        });
    }

}
