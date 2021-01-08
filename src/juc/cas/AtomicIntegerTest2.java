package juc.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: anzhi
 * @Date: 2020/12/25 17:58
 */
public class AtomicIntegerTest2 {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
//        boolean result = atomicInteger.compareAndSet(0, 1);
//        System.out.println(result);
//        System.out.println(atomicInteger.get());

        /**
         * main线程第二次调用compareAndSet方法时，
         * value的值以及被修改为1，不符合expect的值，所以修改失败
         */
        // UnSafe类中的CAS方法是一条CPU并发原语，由若干条指令组成，
        // 用于完成某个功能的一个过程
        boolean firstResult = atomicInteger.compareAndSet(0, 1);
        boolean secondResult = atomicInteger.compareAndSet(0, 1);
        System.out.println(firstResult);
        System.out.println(secondResult);
        System.out.println(atomicInteger.get());
    }

    /**
     * CAS并不是完美的，存在以下缺点
     * 1.如果刚好while里的CAS操作一直不成功，那么对CPU的开销大
     * 2.只能确保一个共享变量的原子操作
     * 3.存在ABA问题
     */









}
