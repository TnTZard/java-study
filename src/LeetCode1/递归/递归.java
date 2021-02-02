package LeetCode1.递归;

import LeetCode1.ListNode;

/**
 * @Author: anzhi
 * @Date: 2021/2/1 14:28
 */
public class 递归 {


    public static void main(String[] args) {
        System.out.println(f(5));
    }

    // 阶乘
    // 1.明确函数的定义
    public static int f(int n) {
        // 2.寻找结束条件
        if (n <= 2) return n;
        // 3.找出函数的等价关系式
        return n * f(n - 1);
    }


    // 斐波那契
    public static int fib(int n) {
        if (n <= 2) return 1;
        return fib(n-1) + fib(n-2);
    }


    // 小青蛙跳台阶
    public static int frog(int n) {
        // 跳一级台阶  一种方法
        // 2 2
        if (n <= 2) return n;
        return frog(n - 1) + frog(n - 2);
    }


    // 反转单链表
    public static ListNode reverseListNode(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newList = reverseListNode(head.next);
        ListNode node1 = head.next;
        node1.next = head;
        head.next = null;
        return newList;
    }

}
