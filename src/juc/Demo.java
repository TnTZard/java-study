package juc;

/**
 * @Author: anzhi
 * @Date: 2021/3/4 14:03
 */
public class Demo {

    public static class MyThread implements Runnable {
        @Override
        public void run() {
            System.out.println("MyThread");
        }
    }

    public static void main(String[] args) {
//        new Thread(new MyThread()).start();
//
//        //
//        new Thread(() -> {
//            System.out.println("Java 8 匿名内部类");
//        }).start();

        Thread testThread = new Thread(() -> {
            System.out.println("testThread当前线程组名字" + Thread.currentThread().getThreadGroup().getName());
            System.out.println("testThread线程名字" + Thread.currentThread().getName());
        });

        testThread.start();
        System.out.println("main当前线程组名字" + Thread.currentThread().getThreadGroup().getName());
        System.out.println("main线程名字" + Thread.currentThread().getName());


    }



}
