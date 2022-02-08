package 程序员代码面试指南.用一个栈实现另一个栈的排序;

import java.util.Stack;

/**
 * @Author: anzhi
 * @Date: 2021/3/30 16:19
 */
public class SortStack {

    public static void sort(Stack<Integer> stack) {

        // 申请一个辅助栈 help
        Stack<Integer> help = new Stack<>();

        while (!stack.isEmpty()) {
            int cur = stack.pop();
            if (cur <= help.peek() || help.isEmpty()) {
                help.push(cur);
            }
        }





    }






}
