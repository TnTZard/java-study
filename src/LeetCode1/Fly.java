package LeetCode1;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: anzhi
 * @Date: 2020/11/4 20:23
 */
public class Fly {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(2);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        reversePrint(listNode1);
    }


    public static int[] reversePrint(ListNode listNode) {
        List<Integer> list = new ArrayList<>();
        while (listNode.next!=null) {

        }
        return null;
    }

}
