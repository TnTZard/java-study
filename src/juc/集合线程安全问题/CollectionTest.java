package juc.集合线程安全问题;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;

/**
 * @Author: anzhi
 * @Date: 2020/12/30 9:56
 */
public class CollectionTest {

    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        IntStream.range(0, 30).forEach(i -> new Thread(() -> list.add(String.valueOf(i))).start());
//        System.out.println(list);
        //Exception in thread "main" java.util.ConcurrentModificationException
        //是因为多个线程并发争抢修改data导致
        //当一个线程正在写入但还未写完时，另一个线程抢夺写入，导致了数据异常

//        useVector();
//        useSynchronizedList();
        useCopyOnWriteArrayList();



    }

    public static void useVector() {
        List<String> list = new Vector<>();
        IntStream.range(0, 30).forEach(i -> new Thread(() -> list.add(String.valueOf(i))).start());
        System.out.println(list);

        // vector类的add方法是通过加同步锁来实现线程安全，查看源码

    }

    public static void useSynchronizedList() {
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        IntStream.range(0, 30).forEach(i -> new Thread(() -> list.add(String.valueOf(i))).start());
        System.out.println(list);
    }

    public static void useCopyOnWriteArrayList() {
        // 通过可重入锁来解决线程安全问题
        // 往一个容器添加元素时，不直接往当前容器Object[]添加，而是先将当前容器Object[]进行复制，复制出一个新的容器Object[] newElements
        // 然后往新的容器里添加元素，添加完成后。再将原容器的引用指向新的容器
        // 这样做的好处是可以对CopyOnWrite的容器进行并发的读，而不需要加锁，因为当前容器不会添加任何元素
        // 所以这也是一种读写分离的思想，即读和写是不同的容器
        List<String> list = new CopyOnWriteArrayList<>();
        IntStream.range(0, 30).forEach(i -> new Thread(() -> list.add(String.valueOf(i))).start());
        System.out.println(list);

    }


}
