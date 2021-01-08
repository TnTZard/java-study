package juc.threadlocal;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: anzhi
 * @Date: 2020/12/28 9:47
 */
public class MyThreadLocal<T> {

    /**
     * 用Map代替ThreadLocalMap
     * 创建一个简易的类ThreadLocal实现
     *
     * 使用建议：
     * 1.将ThreadLocal变量指定为private static;
     * 2.使用完毕后显示地调用remove方法移除
     *
     *
     */

    private final Map<Thread, T> threadLocalMap = new HashMap<>();

    public void set(T t) {
        synchronized (this) {
            Thread key = Thread.currentThread();
            threadLocalMap.put(key, t);
        }
    }

    public T get() {
        synchronized (this) {
            Thread key = Thread.currentThread();
            T t = threadLocalMap.get(key);
            if (t == null) {
                return initialValue();
            } else {
                return t;
            }
        }
    }

    public T initialValue() {
        return null;
    }

}
