package LeetCode1;
import 基础语法.A;

import java.util.*;
/**
 * @Author: anzhi
 * @Date: 2021/2/22 10:29
 */
public class 绝对差不超过限制的最长连续子数组 {


    public static void main(String[] args) {
        System.out.println(2970+626);
    }

    /***
     * 给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，
     * 该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
     *
     * 如果不存在满足条件的子数组，则返回 0 。
     *
     * */

    public int longestSubarray(int[] nums, int limit) {

        // 使用left和right两个指针 分别指向滑动窗口的左右边界
        int left = 0, right = 0;
        // 定义TreeMap保存滑动窗口的所有元素
        TreeMap<Integer, Integer>  map = new TreeMap<>();
        // 定义返回值 数组长度
        int res = 0;
        while (right < nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.lastKey() - map.firstKey() > limit) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left ++;
            }
            res = Math.max(res, right - left + 1);
            right ++;
        }
        return res;
    }


    public int longestSubarray2(int[] nums, int limit) {
        Deque<Integer> maxQueue = new ArrayDeque<>();
        Deque<Integer> minQueue = new ArrayDeque<>();
        int left = 0, right = 0, res = 0;
        while (right < nums.length) {
            while (!maxQueue.isEmpty() && nums[right] > maxQueue.peekLast()) {
                maxQueue.removeLast();
            }
            while (!minQueue.isEmpty() && nums[right] < minQueue.peekLast()) {
                minQueue.removeLast();
            }
            maxQueue.add(nums[right]);
            minQueue.add(nums[right]);
            right++;
            while (maxQueue.peek() - minQueue.peek() > limit) {
                if (maxQueue.peek() == nums[left]) {
                    maxQueue.remove();
                }
                if (minQueue.peek() == nums[left]) {
                    minQueue.remove();
                }
                left += 1;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }


}
