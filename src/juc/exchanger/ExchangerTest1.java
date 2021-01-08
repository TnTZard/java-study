package juc.exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

/**
 * @Author: anzhi
 * @Date: 2020/12/24 18:11
 */
public class ExchangerTest1 {

    public static void main(String[] args) {
        final Exchanger<Object> exchanger = new Exchanger<>();

        new Thread(() -> {
            System.out.println("thread1开始");
            Object object = new Object();
            System.out.println("thread1发送数据：" + object);
            try {
                Object exchange = exchanger.exchange(object);
                //String exchange = exchanger.exchange("来自thread1的数据");
                System.out.println("接收thread2发送的数据：" + exchange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread1结束");
        }, "thread1").start();

        new Thread(() -> {
            System.out.println("thread2开始");
            Object object = new Object();
            System.out.println("thread2发送数据：" + object);
            try {
                TimeUnit.SECONDS.sleep(3);
                Object exchange = exchanger.exchange(object);
                //String exchange = exchanger.exchange("来自thread2的数据");
                System.out.println("接收thread1发送的数据：" + exchange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread2结束");
        }, "thread2").start();

    }

}
