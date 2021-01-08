package juc;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Author: anzhi
 * @Date: 2020/11/17 14:51
 */
public class JUCStudy {

    private int a = 11;
    private int b;
    private int c;

    public JUCStudy(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static void main(String[] args) {
        JUCStudy s = new JUCStudy(1, 2, 3);
    }

}
