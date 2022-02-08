package 程序员代码面试指南.设计一个有getmin功能的栈;

import java.util.Stack;

/**
 * @Author: anzhi
 * @Date: 2021/3/30 14:53
 */
public class MyStack2 {


    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack2() {
        // 初始化
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    private void push(int newNum) {
        if (stackMin.isEmpty()) {
            this.stackMin.push(newNum);
        } else if (newNum < this.getMin()) {
            this.stackMin.push(newNum);
        } else {
            int newMin = this.stackMin.peek();
            this.stackMin.push(newMin);
        }
        this.stackData.push(newNum);
    }

    private int pop() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        this.stackMin.pop();
        return this.stackData.pop();
    }

    private int getMin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("最小值栈为空");
        }
        return this.stackMin.peek();
    }


}
