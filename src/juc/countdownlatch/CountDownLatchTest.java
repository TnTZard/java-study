package juc.countdownlatch;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @Author: anzhi
 * @Date: 2020/12/24 15:54
 */
public class CountDownLatchTest {

    private static ExecutorService executorService = Executors.newFixedThreadPool(2);

    private static CountDownLatch latch = new CountDownLatch(10);

    public static void main(String[] args) throws InterruptedException {
        // 模拟从数据库获取数据
        int[] data = query();
        System.out.println("获取数据完毕");
        // 数据处理
        IntStream.range(0, data.length).forEach(i -> {
            executorService.execute(() -> {
                System.out.println(Thread.currentThread() + "处理第" + (i + 1) + "条数据");
                int value = data[i];
                if (value % 2 == 0) {
                    data[i] = value * 2;
                } else {
                    data[i] = value * 10;
                }
                latch.countDown();
            });
        });
        // 关闭线程池
        latch.await();
        System.out.println("处理结束");
        executorService.shutdown();
        // 保存数据
        save(data);
    }

    private static int[] query() {
        return new int[]{1,2,3,4,5,6,7,8,9,10};
    }

    private static void save(int[] data) {
        System.out.println("保存数据 - " + Arrays.toString(data));
    }
}
