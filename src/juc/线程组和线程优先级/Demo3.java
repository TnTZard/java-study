package juc.线程组和线程优先级;

/**
 * @Author: anzhi
 * @Date: 2021/3/4 15:28
 */
public class Demo3 {

    public static void main(String[] args) {



        ThreadGroup threadGroup1 = new ThreadGroup("group1") {
            // 继承ThreadGroup并重新定义以下方法
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName() + ": " + e.getMessage());
            }
        };

        Thread thread1 = new Thread(threadGroup1, new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException("测试异常");
            }
        });

        thread1.start();
    }
}
