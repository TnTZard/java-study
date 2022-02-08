package hashmap;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: anzhi
 * @Date: 2021/1/6 14:53
 */
public class HashMapTest {

    public static void main(String[] args) {
        long a = 2126;
        int b = Math.floorDiv(2126, 200);
        System.out.println(b);
        // 初始化一组字符串集合，这里初始化了7个
//        List<String> list = new ArrayList<>();
//        list.add("jlkk");
//        list.add("lopi");
//        list.add("小傅哥");
//        list.add("e4we");
//        list.add("alpo");
//        list.add("yhjk");
//        list.add("plop");
//
//        list = list.stream().filter(w -> w.equals("e4we")).collect(Collectors.toList());
//
//        // 定义一个数组用于存放字符串，这里长度是8,2的倍数
//        String[] arr = new String[8];
//
//        // 循环存放数据 计算出每个字符串在数组中的位置 key.hashCode() & (arr.length - 1)
//        for (String key : list) {
//            System.out.println("[hashCode] -> " + key.hashCode() + " & " + (arr.length - 1));
//            int idx = key.hashCode() & (arr.length - 1);
//            System.out.println(String.format("key值=%s Idx=%d", key, idx));
//            if (null == arr[idx]) {
//                arr[idx] = key;
//                continue;
//            }
//            // 在字符串存放到数组的过程中，如果遇到相同的元素，进行连接操作
//            arr[idx] = arr[idx] + "->" + key;
//        }
//
//        System.out.println();
    }




}
