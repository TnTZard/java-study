package 程序员代码面试指南.设计一个有getmin功能的栈;

import java.util.Stack;

/**
 * @Author: anzhi
 * @Date: 2021/3/30 14:43
 */
public class MyStack1 {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack1() {
        // 初始化
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    private void push(int newNum) {
        if (stackMin.isEmpty()) {
           this.stackMin.push(newNum);
        } else if (newNum < this.getMin()) {
           this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }

    private int pop() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        int value = this.stackData.pop();
        if (value == this.getMin()) {
            this.stackMin.pop();
        }
        return value;
    }

    private int getMin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("最小值栈为空");
        }
        return stackMin.peek();
    }




}
