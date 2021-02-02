package 剑指Offer;
import LeetCode1.ListNode;

import java.util.*;
/**
 * @Author: anzhi
 * @Date: 2021/2/1 11:44
 */
public class 链表中倒数第k个节点 {

    public static void main(String[] args) {

    }

    public static ListNode getKthFromEnd(ListNode head, int k) {
        // 初始化 前指针former 后指针latter
        ListNode former = head, latter = head;
        // 构建双指针距离 前指针former先向前走k步
        for (int i=0; i<k; i++) {
            former = former.next;
        }
        while (null != former) {
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }

}
