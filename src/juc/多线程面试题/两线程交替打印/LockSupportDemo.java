package juc.多线程面试题.两线程交替打印;

import java.util.concurrent.locks.LockSupport;

/**
 * @author xiezq1
 * @version 1.0.0
 * @date 2022/2/2 18:02
 */
public class LockSupportDemo {

    static Thread t1 = null, t2 = null;

    public static void main(String[] args) {
        char[] aI = "123456789".toCharArray();
        char[] aC = "ABCDEFGHIJK".toCharArray();

        t1 = new Thread(() -> {
            for (char c : aI) {
                // 先打印数字
                System.out.println(c);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        }, "t1");

        t2 = new Thread(() -> {
            for (char c : aC) {
                // 先阻塞
                LockSupport.park();
                System.out.println(c);
                LockSupport.unpark(t1);
            }
        }, "t2");

        t1.start();
        t2.start();
    }



}
