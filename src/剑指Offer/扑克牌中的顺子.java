package 剑指Offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: anzhi
 * @Date: 2021/1/29 18:31
 */
public class 扑克牌中的顺子 {


    public static void main(String[] args) {

    }

    // 0 0 3 4 5
    public static boolean isStraight(int[] nums) {
        // 数组长度为5 先排序
        // 如果有重复的数字 返回false
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for (int num: nums) {
            if (num == 0) continue;
            max = Math.max(max, num);
            min = Math.min(min, num);
            if (repeat.contains(num)) return false;
            repeat.add(num);
        }
        return max - min < 5;

        // 最普通的情况 连续数字


        // 掺杂王 0
    }


}
