package LeetCode1.每日一题;

import java.util.*;

/**
 * @Author: anzhi
 * @Date: 2021/3/5 9:23
 */
public class 用栈实现队列 {

    class MyQueue {

        Stack<Integer> A;
        Stack<Integer> B;

        /** Initialize your data structure here. */
        public MyQueue() {
            A = new Stack<>();
            B = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            // 每次A中push一个
            A.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (B.isEmpty()) {
                AtoB();
            }
            return B.pop();
        }

        /** Get the front element. */
        public int peek() {
            if (B.isEmpty()) {
                AtoB();
            }
            return B.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return B.isEmpty() && A.isEmpty();
        }

        private void AtoB() {
            while (!A.isEmpty()) {

                B.push(A.pop());
            }
        }


    }

    class CQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;

        public CQueue() {
            // 构造函数 初始化
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void appendTail(int value) {
            // 向第一个栈添加数据
            stack1.add(value);
        }

        public int deleteHead() {
            // 如果第二个栈不为空，直接
            if (!stack2.isEmpty()) {
               return stack2.pop();
            } else {
                // 如果第二个栈为空，将第一个栈的数据pop进栈2
                if (stack1.isEmpty()) return -1;
                while (!stack1.isEmpty()) {
                    stack2.add(stack1.pop());
                }
                return stack2.pop();
            }
        }


    }

}
