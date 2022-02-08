//package juc.多线程面试题.两线程交替打印;//package juc.多线程面试题.两线程交替打印;
//
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.atomic.AtomicInteger;
//import java.util.concurrent.locks.Condition;
//import java.util.concurrent.locks.ReentrantLock;
//
///**
// * @Author: anzhi
// * @Date: 2021/4/20 14:57
// */
//public class Test3 {
//
//
//    private int max;
//    private AtomicInteger status = new AtomicInteger(1);
//
//    private ReentrantLock lock = new ReentrantLock();
//    private Condition odd = lock.newCondition();
//    private Condition even = lock.newCondition();
//
//    public Test3(int max) {
//        this.max = max;
//    }
//
//    public static void main(String[] args) {
//        Test3 test3 = new Test3(100);
//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        executorService.submit(test3.new MyPrinter("Print1", 0));
//        executorService.submit(test3.new MyPrinter("Print2", 1));
//        executorService.shutdown();
//    }
//
//    class MyPrinter implements Runnable {
//
//        private String name;
//        private int type;
//
//        public MyPrinter(String name, int type) {
//            this.name = name;
//            this.type = type;
//        }
//
//
//        @Override
//        public void run() {
//            if (type == 1) {
//                while (status.get() <= max) {
//                    lock.lock();
//                    try {
//                        if (status.get() % 2 == 0) {
//                            odd.await();
//                        }
//                        if (status.get() <= max) {
//                            System.out.println(name + " - " + status.getAndIncrement());
//                        }
//                        even.signal();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    } finally {
//                        lock.unlock();
//                    }
//                }
//            } else {
//
//            }
//        }
//    }
//
//
//
//}
