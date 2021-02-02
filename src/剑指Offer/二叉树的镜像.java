package 剑指Offer;

import LeetCode1.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author: anzhi
 * @Date: 2021/2/1 14:16
 */
public class 二叉树的镜像 {

    public static void main(String[] args) {

    }

    /**
     * 对于二叉树中任意节点root
     * 设其左右子节点分别为left，right
     * 则在二叉树的镜像中的对应root节点
     * 其左右子节点分别为right、left
     */

    public static TreeNode mirrorTree(TreeNode root) {
        // 递归法
        // 终止条件: 当节点root为空时，则返回null
        if (root == null) return null;

        // 递推工作: 1.初始化节点tmp, 用于暂存root的左子节点
        TreeNode tmp = root.left;
        // 2.开启递归右子节点，并将返回值作为root的左子节点
        root.left = mirrorTree(root.right);
        // 3.开启递归左子节点，并将返回值作为root的右子节点
        root.right = mirrorTree(tmp);

        // 返回值: 当前节点root
        return root;
    }



    public static TreeNode mirrorTree1(TreeNode root) {
        // 当root为空时，直接返回null
        if (root == null) return null;
        // 初始化
        Stack<TreeNode> stack = new Stack<TreeNode>() {{add(root);}};
        // 循环交换
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (null != node.left) stack.add(node.left);
            if (null != node.right) stack.add(node.right);
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }




}
