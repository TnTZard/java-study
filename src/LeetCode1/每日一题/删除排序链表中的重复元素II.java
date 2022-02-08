package LeetCode1.每日一题;

import LeetCode1.ListNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: anzhi
 * @Date: 2021/3/25 9:36
 */
public class 删除排序链表中的重复元素II {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0, head);
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            if (current.next.val == current.next.next.val) {
                int x = current.next.val;
                while (current.next != null && current.next.val == x) {
                    current.next = current.next.next;
                }
            } else {
                current = current.next;
            }
        }
        return dummy.next;
    }

    // 向一个链表的末尾插入节点
    public ListNode tailInsert(ListNode node, ListNode newNode) {
        ListNode n = node.next;
        while (n != null) {
            if (n.next == null) {
                n.next = newNode;
            }
            n = n.next;
        }
        return n;
    }


}
