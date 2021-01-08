package juc.vola;

import juc.Singleton;

/**
 * @Author: anzhi
 * @Date: 2020/12/25 10:36
 */
public class SingletonTest {

    // 私有化构造函数
    private SingletonTest() {}

    // 单例对象
    // 通过volatile修饰的成员变量会添加内存屏障来阻止JVM进行指令重排优化
    private volatile static SingletonTest instance = null;

    public static SingletonTest getInstance() {
        if (instance == null) {
            synchronized (SingletonTest.class) {
                if (instance == null) {
                    // 1.分配存储SingletonTest对象的内存空间
                    // 2.初始化SingletonTest对象
                    // 3.将instance指向刚刚分配的内存空间
                    // 第二步和第三步可能会重排序，导致在多线程下出问题
                    instance = new SingletonTest();
                }
            }
        }
        return instance;
    }





}


