package 剑指Offer.中等;

import java.util.*;

/**
 * @Author: anzhi
 * @Date: 2021/3/3 15:17
 */
public class 数组中数字出现的次数II {


    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i= nums.length-1; i>=0; --i) {
            int key = nums[i];
            if (!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                map.put(key, -1);
            }
        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;

    }






}
