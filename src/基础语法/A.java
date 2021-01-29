package 基础语法;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.IntStream;

/**
 * @Author: anzhi
 * @Date: 2021/1/11 9:50
 */
public class A {

    private static SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");



    private final void a() {
        System.out.println("afangfa");
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("7");
        list.add("4");
        list.add("8");
        list.add("3");
        list.add("9");
        List<Integer> list1 = new ArrayList<>();
        IntStream.range(0, 10).forEach(list1::add);
        Collections.sort(list);
//        Collections.sort(list, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o2.compareTo(o1);
//            }
//        });
        // Collections.sort(list, Collections.<String>reverseOrder());
        // 洗牌算法
        //Collections.shuffle(list1);
        Collections.rotate(list1, 2);
        System.out.println(list1);
        // TimSort 是一个归并排序做了大量优化的版本
//        int idx = Collections.binarySearch(list, "100");
//        int idy = Collections.binarySearch(list1, 20);
//        System.out.println("二分查找：" + idy);
//        System.out.println(list);

//        List<String> list3 = Collections.synchronizedList(new ArrayList<String>());
//        list3.set()


    }


    public void seckillSku() {
        String dateStr = f.format(new Date());
    }


    private static final int SHUFFLE_THRESHOLD        =    5;


    public static void shuffle(List<?> list, Random rnd) {
        int size = list.size();
        if (size < SHUFFLE_THRESHOLD || list instanceof RandomAccess) {
            for (int i=size; i>1; i--) {
                swap(list, i-1, rnd.nextInt(i));
            }
        } else {
            Object arr[] = list.toArray();
            for (int i=size; i>1; i--) {
                swap(arr, i-1, rnd.nextInt(i));
            }

            ListIterator it = list.listIterator();
            for (int i=0; i<arr.length; i++) {
                it.next();
                it.set(arr[i]);
            }
        }
    }

    public static void swap(List<?> list, int i, int j) {
        final List l = list;
        l.set(i, l.set(j, l.get(i)));
    }

    public static void swap(Object[] arr, int i, int j) {
        Object tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
