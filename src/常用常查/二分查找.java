package 常用常查;

import java.util.*;

/**
 * @Author: anzhi
 * @Date: 2021/3/29 14:21
 */
public class 二分查找 {

    public static void main(String[] args) {
//        int[] nums = {1, 22, 3, 90, 56, 77, 100, 23, 45};
//        System.out.println(exist(nums, 22));
        //System.out.println((9 - 0) >> 1);
        System.out.println(Integer.MIN_VALUE);
        Map<Integer, Integer> map = new TreeMap<>();
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(0, 2);
        Collections.sort(list);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    /**
     * >> 带符号右移
     *
     * @param sortedArr  有序数组 从小到大
     * @param num 查找数
     * @return
     */
    public static boolean exist(int[] sortedArr, int num) {
        if (sortedArr == null || sortedArr.length == 0) {
            return false;
        }
        int L = 0;
        int R = sortedArr.length - 1;
        int mid = 0;
        while (L < R) {
            mid = L + ((R - L) >> 1); // mid = (L + R) / 2
            if (sortedArr[mid] == num) {
                return true;
            } else if (sortedArr[mid] > num) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return sortedArr[L] == num;
    }




}
