package LeetCode1.每日一题;

import java.util.Stack;

/**
 * @Author: anzhi
 * @Date: 2021/3/24 17:33
 */
public class 题132模式 {

    public static void main(String[] args) {
        int[] nums = {-1, 3, 2, 0};
    }

    public boolean find132pattern(int[] nums) {

        int length = nums.length;
        if (length < 3) return false;
        Stack<Integer> stack = new Stack<>();
        int k=-1;
        for (int i=length-1; i>=0; i--) {
            if (k>-1 && nums[k] > nums[i]) {
                return true;
            }
            while (!stack.isEmpty()&&nums[stack.peek()]<nums[i]) {
                k = stack.pop();
            }
            stack.push(i);
        }


        return true;
    }






}
