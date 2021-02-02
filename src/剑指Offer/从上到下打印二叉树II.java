package 剑指Offer;

import LeetCode1.TreeNode;

import java.util.*;

/**
 * @Author: anzhi
 * @Date: 2021/2/2 10:38
 */
public class 从上到下打印二叉树II {


    /**
     *
     * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
     *
     *
     */


    // 层序遍历 BFS
    // BFS 通常借助队列的先入先出特性来实现
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 初始化
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        // 当根节点为空 返回空列表[]
        if (null != root) {
            queue.add(root);
        }
        // BFS循环 当队列queue为空时跳出
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }



}
