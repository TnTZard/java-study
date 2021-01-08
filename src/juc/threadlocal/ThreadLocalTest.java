package juc.threadlocal;

/**
 * @Author: anzhi
 * @Date: 2020/12/28 9:21
 */
public class ThreadLocalTest {

    /**
     * ThreadLocal字面上的意思是局部线程变量
     * 每个线程通过ThreadLocal的get和set方法来访问和修改线程自己独有的变量
     * 简单来说
     * ThreadLocal的作用就是为每一个线程提供了一个独立的变量副本
     * 每一个线程都可以独立地改变自己的副本，而不会影响其他线程对应的副本
     */

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    // 设置初始值有两种方式
    private static ThreadLocal<String> threadLocal2 = new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return "Alice";
        }
    };

    private static ThreadLocal<String> threadLocal3 = ThreadLocal.withInitial(() -> "Tom");

    public static void main(String[] args) {
        threadLocal.set("hello");
        System.out.println(threadLocal.get());
        threadLocal.remove();
        System.out.println(threadLocal.get());
        System.out.println(threadLocal2.get());
        System.out.println(threadLocal3.get());
        threadLocal3.remove();
        // remove无法移除初始值
        System.out.println(threadLocal3.get());
    }


}
