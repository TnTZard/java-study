package 剑指Offer;

import LeetCode1.ListNode;

/**
 * @Author: anzhi
 * @Date: 2021/1/29 14:22
 */
public class 两个链表的第一个公共节点 {

    public static void main(String[] args) {

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA, node2 = headB;
        while (node1 != node2) {
            node1 = (node1 == null ? headB : node1.next);
            node2 = (node2 == null ? headA : node2.next);
        }
        return node1;
    }


}
