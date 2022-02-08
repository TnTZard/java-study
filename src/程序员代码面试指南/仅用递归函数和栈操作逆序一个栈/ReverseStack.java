package 程序员代码面试指南.仅用递归函数和栈操作逆序一个栈;

import java.util.Stack;

/**
 * @Author: anzhi
 * @Date: 2021/3/30 14:59
 */
public class ReverseStack {



    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        System.out.println(getAndRemoveLastElement(myStack));
    }

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

    public static int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }



}
