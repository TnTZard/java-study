package 剑指Offer;

import LeetCode1.ListNode;

/**
 *
 * 剑指 Offer 18. 删除链表的节点
 * @Author: anzhi
 * @Date: 2021/1/28 15:15
 */
public class 删除链表的节点 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();
        ListNode node4 = new ListNode();
        node1.val = 4;
        node2.val = 5;
        node3.val = 1;
        node4.val = 9;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        System.out.println(deleteNode1(node1, 1).val);

    }

    public static ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) return head.next;
        ListNode pre = head, cur = head.next;
        while (null != cur && cur.val != val) {
            // 一个接一个下去 找到当val一致的时候  定位节点
            // 修改引用
            pre = cur;
            cur = cur.next;
        }
        if (null != cur) pre.next = cur.next;
        return head;
    }


    public static ListNode deleteNode1(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) return head.next;
        ListNode current = head;
        while (current.next != null && current.next.val != val) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
        return head;
    }
}
