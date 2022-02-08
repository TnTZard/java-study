package LeetCode1.每日一题;

import LeetCode1.ListNode;

import java.util.HashMap;

/**
 * @Author: anzhi
 * @Date: 2021/3/29 18:02
 */
public class 旋转链表 {

    public static void main(String[] args) {

//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        System.out.println(rotateRight(node1, 2));
        System.out.println(64 >>> 16);
        //System.out.println(2 % 5);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) return head;
        int n = 1;
        ListNode iter = head;
        while (iter.next != null) {
            iter = iter.next;
            n++;
        }
        int offset = n - k % n;
        if (offset == n) return head;
        iter.next = head;
        while (offset-- > 0) {
            iter = iter.next;
        }
        ListNode ret = iter.next;
        iter.next = null;
        return ret;


    }


}
