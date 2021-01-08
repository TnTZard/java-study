package juc.sema;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Author: anzhi
 * @Date: 2020/12/25 11:04
 */
public class SemaphoreTest2 {

    public static void main(String[] args) throws InterruptedException {
        final Semaphore semaphore = new Semaphore(1);
        Thread thread = new Thread(() -> {
            //semaphore.acquireUninterruptibly(2);


            try {
                semaphore.acquire(2);
            } catch (InterruptedException e) {
                System.out.println("semaphore InterruptedException");
                e.printStackTrace();
            }
        });
        thread.start();
        TimeUnit.MICROSECONDS.sleep(500);
        thread.interrupt();
    }






}
