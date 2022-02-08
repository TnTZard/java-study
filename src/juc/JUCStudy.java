package juc;

import com.sun.corba.se.impl.orbutil.ObjectWriter;
import juc.cas.AtomicIntegerTest;
import sun.misc.Unsafe;

import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
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
        String a = "";
        ConcurrentHashMap concurrentHashMap;
        HashMap map;
        JUCStudy s = new JUCStudy(1, 2, 3);

        for (int i=0; ; i++) {
            System.out.println("hello");
        }

    }

}
