package 剑指Offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: anzhi
 * @Date: 2021/2/1 9:46
 */
public class 滑动窗口的最大值 {


    public static void main(String[] args) {

    }


    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int j = 0, i = 1 - k; j < nums.length; i++, j++) {
            if (i > 0 && deque.peekFirst() == nums[i - 1]) {
                deque.removeFirst(); // 删除队列中对应的nums[i-1]
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[j]) {
                deque.removeLast(); // 保持deque递减
            }
            if (i >= 0) {
                // 记录窗口最大值
                res[i] = deque.peekFirst();
            }
        }
        return res;
    }

    public static int[] maxSlidingWindow1(int[] nums, int k) {
        int left = 0, right = k - 1, max;
        // 数组大小 = 窗口数量
        int[] res = new int[nums.length - k + 1];
        while (right < nums.length) {
            // 判断窗口内最大值 将最大值放入数组


        }

        // 移动窗口
        return null;
    }

}
