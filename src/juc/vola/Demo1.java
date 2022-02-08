package juc.vola;

/**
 * @Author: anzhi
 * @Date: 2021/3/5 11:15
 */
public class Demo1 {

    int a = 0;
    volatile boolean flag = false;

    public void writer() {
        a = 1;
        flag = true;
    }

    public void reader() {
        if (flag) System.out.println(a);
    }





}
