package 剑指Offer;

import LeetCode1.ListNode;
import LeetCode1.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author: anzhi
 * @Date: 2021/2/1 16:40
 */
public class 合并两个排序的链表 {


    /**
     *
     *
     */


    public static void main(String[] args) {

    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode(0), cur = dum;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = (l1 != null ? l1: l2);
        return dum.next;
    }


    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        return recur(l1, l2);
    }

    public static ListNode recur(ListNode l1, ListNode l2) {
        if (null == l1 && null == l2) return null;
        if (null == l1) return l2;
        if (null == l2) return l1;

        // 新建头结点
        ListNode head = null;

        if (l1.val <= l2.val) {
            head = new ListNode(l1.val);
            head.next = recur(l1.next, l2);
        } else {
            head = new ListNode(l2.val);
            head.next = recur(l1, l2.next);
        }
        return head;
    }

}
