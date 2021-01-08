package juc.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * @Author: anzhi
 * @Date: 2020/12/28 10:14
 */
public class Test {
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        IntStream.rangeClosed(0,1).forEach(i -> {
            new Thread(Test::method3, String.valueOf(i)).start();
        });
    }


    public static void method1() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " invoked method1");
            method2();
        } finally {
            lock.unlock();
        }
    }

    public static void method2() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " invoked method2");
        } finally {
            lock.unlock();
        }
    }

    public static void method3() {
        lock.lock();
        lock.lock();
        lock.lock();
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " invoked method3");
        } finally {
            lock.unlock();
            lock.unlock();
            lock.unlock();
        }
    }



}
