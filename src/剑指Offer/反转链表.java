package 剑指Offer;

import LeetCode1.ListNode;

/**
 * 剑指 Offer 24. 反转链表
 * @Author: anzhi
 * @Date: 2021/1/28 16:24
 */
public class 反转链表 {

    public static void main(String[] args) {

    }

    // 双指针
    public static ListNode reverseList(ListNode head) {
        ListNode pre = head, cur = null;
        while (null != pre) {
            ListNode temp = pre.next;
            pre.next = cur;
            cur = pre;
            pre = temp;
        }
        return cur;
    }


}
