package 剑指Offer;

import LeetCode1.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: anzhi
 * @Date: 2021/2/1 15:27
 */
public class 二叉树的深度 {

    public static void main(String[] args) {

    }


    /**
     * 树的遍历方式总体分为两类
     * 深度优先搜索 DFS
     * 广度优先搜索 BFS
     */

    // 方法一: 后序遍历 DFS     利用 栈 或 递归 实现

    /**
     * 树深度 = max(左子树深度，右子树深度) + 1
     */
    public static int maxDepth(TreeNode root) {
        // 终止条件: 当root为空，说明已越过叶节点，因此返回0
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    // 方法二: 层序遍历 BFS   利用队列实现
    public static int maxDepth1(TreeNode root) {
        if (root == null) return 0;
        // 初始化
        List<TreeNode> queue = new LinkedList<TreeNode>() {{add(root);}}, tmp;
        int res = 0;
        // 当queue为空时跳出
        while (!queue.isEmpty()) {
            tmp = new LinkedList<>();
            for (TreeNode node: queue) {
                if (node.left != null) tmp.add(node.left);
                if (node.right != null) tmp.add(node.right);
            }
            queue = tmp;
            res++;
        }
        return res;
    }

    public static int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{add(root);}};
        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            int n = queue.size();
            for (int i=0; i<n; i++) {
                TreeNode node = queue.poll();
                if (null != node.left) queue.add(node.left);
                if (null != node.right) queue.add(node.right);
            }
        }
        return res;
    }








}
