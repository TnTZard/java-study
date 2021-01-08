package juc.vola;

import java.util.stream.IntStream;

/**
 * @Author: anzhi
 * @Date: 2020/12/25 10:44
 */
public class VolatileTest3 {

    private volatile static int value;

    /*
        在JAVA中，只有对基本类型的赋值和修改才是原子性的，而对共享变量的修改不是原子性的
     */
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> IntStream.range(0,500).forEach(i -> value+=1));
        Thread thread2 = new Thread(() -> IntStream.range(0,500).forEach(i -> value+=1));

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(value);
    }

}
