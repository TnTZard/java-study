package juc.线程组和线程优先级;

import java.util.stream.IntStream;

/**
 * @Author: anzhi
 * @Date: 2021/3/4 15:16
 */
public class Demo2 {


    public static class T1 extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.println(String.format("当前执行的线程是：%s, 优先级：%d",
                    Thread.currentThread().getName(),
                    Thread.currentThread().getPriority()));
        }
    }

    public static void main(String[] args) {
        IntStream.range(1, 10).forEach(i -> {
            Thread thread = new Thread(new T1());
            thread.setPriority(i);
            thread.start();
        });
    }

}
