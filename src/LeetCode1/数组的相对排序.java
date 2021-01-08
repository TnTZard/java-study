package LeetCode1;

import java.util.*;

/**
 * @Author: anzhi
 * @Date: 2020/11/14 16:32
 */
public class 数组的相对排序 {

    public static void main(String[] args) {
      int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19}, arr2 = {2,1,4,3,9,6};
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num: arr1) {
            list.add(num);
        }
        for (int i=0; i<arr2.length; i++) {
            map.put(arr2[i], i);
        }
        Collections.sort(list, (x, y) -> {
            if (map.containsKey(x) || map.containsKey(y)) {
                return map.getOrDefault(x, 1001) - map.getOrDefault(y, 1001);
            }
            return x - y;
        });

        for (int i=0; i<arr1.length; i++) {
            arr1[i] = list.get(i);
        }
        return arr1;
    }






}
