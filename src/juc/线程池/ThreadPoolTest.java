package juc.线程池;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: anzhi
 * @Date: 2020/12/30 11:50
 */
public class ThreadPoolTest {


    /**
     * 由于线程的创建和销毁都需要消耗一定的CPU资源
     * 所以在高并发下这种创建线程的方式严重影响代码执行效率
     * 而线程池的作用就是让一个线程执行结束后不马上销毁，继续执行新的任务
     * 这样就节省了不断创建线程和销毁线程的开销
     */


    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 10,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(1), (ThreadFactory) Thread::new, new ThreadPoolExecutor.AbortPolicy());
        System.out.println("线程池创建完毕");

        threadPoolExecutor.execute(() -> sleep(100));
        threadPoolExecutor.execute(() -> sleep(100));
        threadPoolExecutor.execute(() -> sleep(100));
        threadPoolExecutor.execute(() -> sleep(100));

        int activeCount = -1;
        int queueSize = -1;
        while (true) {
            if (activeCount != threadPoolExecutor.getActiveCount() ||
                    queueSize != threadPoolExecutor.getQueue().size()) {
                System.out.println("活跃线程个数：" + threadPoolExecutor.getActiveCount());
                System.out.println("核心线程个数：" + threadPoolExecutor.getCorePoolSize());
                System.out.println("队列线程个数：" + threadPoolExecutor.getQueue().size());
                System.out.println("最大线程数：" + threadPoolExecutor.getMaximumPoolSize());
                System.out.println("-----------------------------");
                activeCount = threadPoolExecutor.getActiveCount();
                queueSize   = threadPoolExecutor.getQueue().size();
            }
        }
        // 上面的代码创建了一个
        // 核心线程数量为1，
        // 允许最大线程数量为2，
        // 最大活跃时间为10秒，
        // 线程队列长度为1的线程池
    }

    /**
     * ThreadPoolExecutor的execute方法和submit方法都可以向线程池提交任务，区别是submit方法能够返回执行结果
     * 返回值类型为Future
     */

    public static void sleep(long value) {
        try {
            System.out.println(Thread.currentThread().getName() + "线程执行sleep方法");
            TimeUnit.SECONDS.sleep(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 线程池核心数量为1，通过execute提交了一个任务后，由于核心线程是空闲的，所以任务被执行了
        // 由于这个任务的逻辑是休眠100s， 所以在100s内，线程池的活跃线程数量为1
        // 此外，因为提交的任务被核心线程执行了，所以并没有线程需要被放到线程队列里等待，线程队列长度为0
        //
    }




}
