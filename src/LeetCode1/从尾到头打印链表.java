package LeetCode1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @Author: anzhi
 * @Date: 2020/11/7 14:46
 */
public class 从尾到头打印链表 {


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(2);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        List<Integer> list = Arrays.stream(reversePrint(listNode1)).boxed().collect(Collectors.toList());
        list.forEach( i -> {
            System.out.println(i);
        });
    }


    public static int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i=0; i<size; i++) {
            print[i] = stack.pop().val;
        }
        return print;
    }

    static ArrayList<Integer> tmp = new ArrayList<>();

    /***************************************************/
    /**
     * 递归
     */
    public static int[] reversePrint2(ListNode head) {
        recur(head);
        int[] res = new int[tmp.size()];
        for (int i=0; i<res.length; i++) {
            res[i] = tmp.get(i);
        }
        return res;
    }
    static void recur(ListNode head) {
        if (head == null) return;
        recur(head.next);
        tmp.add(head.val);
    }
    /***************************************************/


    /**
     *     //上一版中使用辅助栈解决 栈和递归往往相关联 这里我们是递归实现
     *     int[] res;
     *     int i;//全局变量
     *     public int[] reversePrint(ListNode head) {
     *         recur(head,0);//递归函数调用
     *         return res;
     *     }
     *     void recur(ListNode head,int count) {
     *         if(head == null)
     *         {//递归终止条件
     *             res = new int[count];
     *             i = count-1;
     *             return;
     *         }
     *         recur(head.next,count+1);
     *         res[i-count] =  head.val; //这里的i-count是重点
     *     }
     */
}
