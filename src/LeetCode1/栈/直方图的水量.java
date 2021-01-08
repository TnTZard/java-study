package LeetCode1.栈;

import java.util.Stack;

/**
 * @Author: anzhi
 * @Date: 2021/1/5 11:05
 */
public class 直方图的水量 {

    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int water = 0;

        if (height.length<3) {
            return 0;
        }

        for (int i = 0; i < height.length; i++) {
            while(!stack.isEmpty() && height[i] > height[stack.peek()]) {
                // 栈顶元素
                int popnum = stack.pop();
                // 相同元素的情况
                while(!stack.isEmpty() && height[popnum] == height[stack.peek()]) {
                    stack.pop();
                }
                // 计算该层的水的单位
                if (!stack.isEmpty()) {
                    int temp = height[stack.peek()];
                    int hig = Math.min(temp-height[popnum], height[i] - height[popnum]);
                    int wid = i - stack.peek() - 1;
                    water += hig * wid;
                }
            }
            // 这里入栈的是索引
            stack.push(i);
        }
        return water;
    }


}
