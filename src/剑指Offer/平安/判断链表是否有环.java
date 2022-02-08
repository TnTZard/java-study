package 剑指Offer.平安;

import LeetCode1.ListNode;

import java.util.*;

/**
 * @Author: anzhi
 * @Date: 2021/3/30 17:45
 */
public class 判断链表是否有环 {

    public static void main(String[] args) {
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list2.add(1);
        list2.add(2);
        set.add(list1);
        set.add(list2);
        System.out.println(set);
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }





}
