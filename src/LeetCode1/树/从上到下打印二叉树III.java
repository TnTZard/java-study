package LeetCode1.树;

import LeetCode1.TreeNode;

import java.util.*;

/**
 * @Author: anzhi
 * @Date: 2021/4/14 15:26
 */
public class 从上到下打印二叉树III {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(9);
        list.addFirst(2);
        System.out.println(list);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        // 队列
        Queue<TreeNode> queue = new LinkedList<>();
        // 结果二维列表
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (res.size() % 2 == 0) {
                    // 偶数层 队列头部
                    tmp.addFirst(node.val);
                } else {
                    // 奇数层 队列尾部
                    tmp.addLast(node.val);
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }


    public List<List<Integer>> levelOrder1(TreeNode root) {
        // 队列
        Queue<TreeNode> queue = new LinkedList<>();
        // 结果二维列表
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            if (res.size() % 2 == 1) Collections.reverse(tmp);
            res.add(tmp);
        }
        return res;
    }



}
