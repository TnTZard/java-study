package juc.sema;

import java.util.Collection;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @Author: anzhi
 * @Date: 2020/12/25 11:43
 */
public class SemaphoreTest4 {

    public static void main(String[] args) {

        final MySemaphore semaphore = new MySemaphore(1);

        IntStream.range(0, 4).forEach(i -> {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "开始");
                try {
                    semaphore.acquire();
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

        while (true) {
            if (semaphore.hasQueuedThreads()) {
                System.out.println("等待线程数量：" + semaphore.getQueueLength());
                Collection<Thread> queuedThreads = semaphore.getQueuedThreads();
                System.out.println("等待线程：" );
            }
        }


    }

    static class MySemaphore extends Semaphore {
        public MySemaphore(int permits) {
            super(permits);
        }

        public MySemaphore(int permits, boolean fair) {
            super(permits, fair);
        }

        public Collection<Thread> getQueuedThreads() {
            return super.getQueuedThreads();
        }
    }
}
