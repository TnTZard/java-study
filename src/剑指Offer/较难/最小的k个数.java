package 剑指Offer.较难;

import java.util.*;

/**
 * TopK问题
 *
 * @Author: anzhi
 * @Date: 2021/1/29 16:40
 */
public class 最小的k个数 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i=0; i < 10000000; ++i) {
//            System.out.println(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("i++耗时：" + (end - start)); //28227
//        long start2 = System.currentTimeMillis();
//        for (int i=0; i < 10000000; ++i) {
//            System.out.println(i);
//        }
//        long end2 = System.currentTimeMillis();
//        System.out.println("++i耗时：" + (end2 - start2)); //29618
    }

    /**  PriorityQueue 基于优先级的无界优先队列 通过用数组表示的小顶堆实现
     *
     *
     *  优先级队列的元素按照其自然顺序进行排序，或者根据构造队列时提供的comparator进行排序
     *  该队列不允许使用null元素也不允许插入不可比较的对象（没有实现Comparable接口的对象）
     *  PriorityQueue的头指排序规则最小的那个元素。如果多个元素都是最小值则随机选一个
     *  PriorityQueue是一个无界队列，支持自动扩容
     *
     *  add(E e)和offer(E e)的语义相同，都是向优先队列中插入元素，
     *  只是Queue接口规定二者对插入失败的处理不同前者在插入失败时抛出异常，后者返回false
     *
     *  element()和peek()的语义相同，都是获取但不删除队首元素，也就是队列中权值最小的那个元素，
     *  二者唯一的区别是当方法失败时，前者抛出异常，后者返回null
     *
     *  remove()和poll()的语义相同，都是获取并删除队首元素，
     *  区别是当方法失败时，前者抛出异常，后者返回null
     *
     * **/

    // 最垃圾的sort
    public static int[] getLeastNumbers(int[] arr, int k) {
        // 构建一个数组
        Arrays.sort(arr);
        int[] res = new int[k];
        for (int i=0; i<k; i++) {
            res[i] = arr[i];
        }
        return res;
    }


    /**    快排     **/
    public static int[] getLeastNumbers1(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 最后一个参数表示我们要找的是下标为k - 1的数
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    public static int[] quickSearch(int[] nums, int lo, int hi, int k) {
        // 每快排切分一次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数
        int j = partition(nums, lo, hi);
        if (j == k) {
            return Arrays.copyOf(nums, j + 1);
        }
        return j > k ? quickSearch(nums, lo, j - 1, k) : quickSearch(nums, j + 1, hi, k);
    }

    public static int partition(int[] nums, int lo, int hi) {
        int v = nums[lo];
        int i = lo, j = hi + 1;
        return 0;
    }


    /** 堆 **/
    public static int[] getLeastNumbers2(int[] arr, int k) {
        int[] vec = new int[k];
        // k=0时 直接返回空数组
        if (k == 0) {
            return vec;
        }
        // 建立堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i=0; i < k; i++) {
            queue.offer(arr[i]);
        }
        // 在大量数据的时候++i的性能要比i++的性能好
        for (int i=k; i < arr.length; i++) {
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            vec[i] = queue.poll();
        }
        return vec;
    }



}
