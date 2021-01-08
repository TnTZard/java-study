package juc.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;

/**
 * @Author: anzhi
 * @Date: 2020/12/28 18:36
 */
public class ReadWriteLockTest {

    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);

    private static ReentrantReadWriteLock.ReadLock readLock = lock.readLock();

    private static ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

    private static List<Long> data = new ArrayList<>();

    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                write();
            }
        }, "writer").start();
        new Thread(() -> {
            while (true) {
                read();
            }
        }, "reader").start();
    }

    public static void write() {
        try {
            writeLock.lock(); // 写锁
            TimeUnit.SECONDS.sleep(1);
            long value = System.currentTimeMillis();
            data.add(value);
            System.out.println(Thread.currentThread().getName() + "写入value：" + value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    public static void read() {
        try {
            readLock.lock();
            TimeUnit.SECONDS.sleep(1);
            String value = data.stream().map(String::valueOf).collect(Collectors.joining(","));
            System.out.println(Thread.currentThread().getName() + "读取data：" + data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }


}
