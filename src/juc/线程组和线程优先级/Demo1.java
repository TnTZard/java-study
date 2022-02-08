package juc.线程组和线程优先级;

/**
 * @Author: anzhi
 * @Date: 2021/3/4 15:12
 */
public class Demo1 {


    public static void main(String[] args) {
        Thread a = new Thread();
        System.out.println("我是默认优先级" + a.getPriority());
        Thread b = new Thread();
        b.setPriority(10);
        System.out.println("我是设定的优先级" + b.getPriority());
    }





}
