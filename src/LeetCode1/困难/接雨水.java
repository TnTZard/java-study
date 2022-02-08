package LeetCode1.困难;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Stack;

/**
 * @Author: anzhi
 * @Date: 2021/3/12 17:06
 */
public class 接雨水 {

    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        String time = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        System.out.println(time);
        System.out.println();
        System.out.println(height.length);
    }
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int i = 0, ans = 0;
        while (i < height.length) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.empty()) break;
                int distance = i - stack.peek() - 1;
                int bounded_height = Math.min(height[i], height[stack.peek()] - height[top]);
                ans += distance * bounded_height;
            }
            stack.push(i++);
        }
        return ans;
    }


}
