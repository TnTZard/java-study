package LeetCode1.树;

import LeetCode1.TreeNode;
import 基础语法.A;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: anzhi
 * @Date: 2021/4/14 14:26
 */
public class 从上到下打印二叉树 {

    /**
     * 层序遍历
     *      将树的根节点入队
     *      循环（当队列不为空时）
     *          队首元素出队
     *          记录出队元素
     *          将出队元素的左右孩子节点入队（队尾）
     *      循环结束
     * @param root
     * @return
     */

    public int[] levelOrder(TreeNode root) {

        if (root == null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<TreeNode>(){{add(root);}};
        ArrayList<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            ans.add(node.val);
            if (node.left != null) queue.add(root.left);
            if (node.right != null) queue.add(root.right);
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }



}
