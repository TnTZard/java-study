//package juc.多线程面试题.两线程交替打印;//package juc.多线程面试题.两线程交替打印;
//
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.atomic.AtomicInteger;
//
///**
// * @Author: anzhi
// * @Date: 2021/4/20 14:42
// */
//public class Test2 {
//
//    Object odd = new Object();
//    Object even = new Object();
//
//    private int max;
//    private AtomicInteger status = new AtomicInteger(1);
//
//    public Test2(int max) {
//        this.max = max;
//    }
//
//    public static void main(String[] args) {
//        Test2 test2 = new Test2(100);
//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        executorService.submit(test2.new MyPrinter("Print1", 0));
//        executorService.submit(test2.new MyPrinter("Print2", 1));
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
//        @Override
//        public void run() {
//            if (type == 1) {
//                while (status.get() <= max) {
//                    if (status.get() % 2 == 0) {
//                        synchronized (odd) {
//                            try {
//                                odd.wait();
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    } else {
//                        System.out.println(name + " - " + status.getAndIncrement());
//                        try {
//                            Thread.sleep(500);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        synchronized (even) {
//                            even.notify();
//                        }
//                    }
//                }
//            } else {
//                while (status.get() <= max) {
//                    if (status.get() % 2 != 0) {
//                        synchronized (even) {
//                            try {
//                                even.wait();
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    } else {
//                        System.out.println(name + " - " + status.getAndIncrement());
//                        try {
//                            Thread.sleep(500);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        synchronized (odd) {
//                            odd.notify();
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//
//
//
//}
