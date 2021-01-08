package juc.vola;

import java.util.concurrent.TimeUnit;

/**
 * @Author: anzhi
 * @Date: 2020/12/25 10:34
 */
public class VolatileTest2 {

    // 为什么 volatile修饰的成员变量在线程间具有可见性
    private volatile static int INIT_VALUE = 0;
    private final static int LIMIT = 5;

    public static void main(String[] args) {
        new Thread(() -> {
            int value = INIT_VALUE;
            while (value < LIMIT) {
                if (value != INIT_VALUE) {
                    System.out.println("获取更新后的值：" + INIT_VALUE);
                    value = INIT_VALUE;
                }
            }
        }, "reader").start();

        new Thread(() -> {
            int value = INIT_VALUE;
            while (INIT_VALUE < LIMIT) {
                System.out.println("将值更新为：" + ++value);
                INIT_VALUE = value;
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "writer").start();


    }

}
