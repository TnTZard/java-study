package LeetCode1;

/**
 * @Author: anzhi
 * @Date: 2020/11/13 9:43
 */
public class 奇偶链表 {


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        oddEvenList(listNode1);
    }


    public static ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        // 偶节点头部
        ListNode evenHead = head.next;
        // 奇节点 ， 偶节点
        ListNode odd = head, even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }



}
