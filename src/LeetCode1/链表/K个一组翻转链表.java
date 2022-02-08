package LeetCode1.链表;

import LeetCode1.ListNode;

/**
 * @Author: anzhi
 * @Date: 2021/4/27 9:51
 */
public class K个一组翻转链表 {




    public ListNode reverseKGroup(ListNode head, int k) {
        // 新建一个头结点之前的节点
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;
        while (head != null) {
            ListNode tail = pre;
            // 查看剩余部分长度是否大于等于k
            for (int i=0; i<k; ++i) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            ListNode nex = tail.next;
            ListNode[] reverse = myReverse(head, tail);
            head = reverse[0];
            tail = reverse[1];

            // 把子链表重新接回原链表
            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;
        }
        return hair.next;
    }

    public ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next, p = head;
        while (prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[] {tail, head};
    }


    /**
     * 单组链表反转
     * @param head
     * @return
     */
    public ListNode reverseNode(ListNode head) {
        ListNode cur = head, pre = null;
        while (cur != null) {
            // 新建一个结点将下一个保存起来
            ListNode tmp = cur.next;
            // 将cur指向下个断开 转而指向前面新创建的pre
            cur.next = pre;
            // 移动cur
            pre = cur;
            cur = tmp;
        }
        return cur;
    }



}
