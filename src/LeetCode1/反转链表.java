package LeetCode1;

/**
 * @Author: anzhi
 * @Date: 2020/11/20 16:16
 */
public class 反转链表 {


    public static void main(String[] args) {

    }


    public static ListNode reverseList(ListNode head) {
        ListNode cur = head, pre = null;
        while (cur!=null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }


}
