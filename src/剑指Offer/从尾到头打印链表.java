package 剑指Offer;

import LeetCode1.ListNode;

import java.util.Stack;

/**
 * @Author: anzhi
 * @Date: 2021/1/25 18:02
 */
public class 从尾到头打印链表 {

    public static void main(String[] args) {

    }

    /**
     * 栈
     * @param head
     * @return
     */
    public static int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] res = new int[size];
        for (int i=0; i<size; i++) {
            res[i] = stack.pop().val;
        }
        return res;
    }






}
