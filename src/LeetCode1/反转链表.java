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
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return cur;
    }

    public static ListNode reverseList1(ListNode head) {
        return recur(head, null);
    }

    // 递归
    public static ListNode recur(ListNode cur, ListNode pre) {
        // 出口
        if (cur == null) return pre;
        // 递归后继节点
        ListNode res = recur(cur.next, cur);
        // 修改节点引用指向
        cur.next = pre;
        return res;
    }


//    ListNode cur = head, pre = null;
//        while (cur!=null) {
//        ListNode tmp = cur.next;
//        cur.next = pre;
//        pre = cur;
//        cur = tmp;
//    }
//        return pre;

}
