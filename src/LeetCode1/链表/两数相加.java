package LeetCode1.链表;

import LeetCode1.ListNode;

/**
 * @author xiezq1
 * @version 1.0.0
 * @date 2022/2/7 16:05
 */
public class 两数相加 {

    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 初始化 l1 l2
        ListNode head1 = l1;
        ListNode head2 = l2;
        while (head1.next != null) {
            if (head2 != null) {
                head1.val += head2.val;
                head2 = head2.next;
            }
            head1 = head1.next;
        }
        merge(l1);
        return l1;
    }

    public void merge(ListNode head) {
        while (head != null) {
            if (head.val >= 10) {
                head.val = head.val % 10;
                head.next.val += 1;
            }
            head = head.next;
        }
    }

}
