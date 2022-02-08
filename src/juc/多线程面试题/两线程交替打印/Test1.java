//package juc.多线程面试题.两线程交替打印;//package juc.多线程面试题.两线程交替打印;
//
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.atomic.AtomicInteger;
//
///**
// * @Author: anzhi
// * @Date: 2021/4/20 14:35
// */
//public class Test1 {
//
//    private int max;
//    private AtomicInteger status = new AtomicInteger(1);
//
//    public Test1(int max) {
//        this.max = max;
//    }
//
//    public static void main(String[] args) {
//        Test1 test1 = new Test1(100);
//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        executorService.submit(test1.new MyPrinter("Print1", 0));
//        executorService.submit(test1.new MyPrinter("Print2", 1));
//        executorService.shutdown();
//    }
//
//    class MyPrinter implements Runnable {
//        private String name;
//        private int type; // 打印的类型
//
//        public MyPrinter(String name, int type) {
//            this.name = name;
//            this.type = type;
//        }
//
//        @Override
//        public void run() {
//            if (type == 1) {
//                while (status.get() <= max) {
//                    synchronized (Test1.class) {
//                        if (status.get() <= max && status.get() % 2 == 0) {
//                            System.out.println(name + " - " + status.getAndIncrement());
//                        }
//                    }
//                }
//            } else {
//                while (status.get() <= max) {
//                    synchronized (Test1.class) {
//                        if (status.get() <= max && status.get() % 2 != 0) {
//                            System.out.println(name + " - " + status.getAndIncrement());
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//}
