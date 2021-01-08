package juc.exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

/**
 * @Author: anzhi
 * @Date: 2020/12/24 16:54
 */
public class ExchangerTest {


    public static void main(String[] args) {
        final Exchanger<String> exchanger = new Exchanger<>();

        new Thread(() -> {
            System.out.println("thread1开始");
            try {
                String exchange = exchanger.exchange("来自thread1的数据");
                System.out.println("接收thread2发送的数据：" + exchange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread1结束");
        }, "thread1").start();

        new Thread(() -> {
            System.out.println("thread2开始");
            try {
                TimeUnit.SECONDS.sleep(3);
                String exchange = exchanger.exchange("来自thread2的数据");
                System.out.println("接收thread1发送的数据：" + exchange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread2结束");
        }, "thread2").start();


    }



}
