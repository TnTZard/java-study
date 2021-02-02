package 剑指Offer;

import LeetCode1.TreeNode;
import java.util.*;
/**
 * @Author: anzhi
 * @Date: 2021/2/2 10:52
 */
public class 平衡二叉树 {

    /**
     * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
     * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
     *
     *
     * 此树的深度 = MAX（左子树的深度，右子树的深度） + 1
     *
     *
     *
     **/


    // 方法一: 后序遍历 + 剪枝
    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    public int recur(TreeNode root) {
        if (root == null) return 0;
        int left = recur(root.left);
        if (left == -1) return -1;
        int right = recur(root.right);
        if (right == -1) return -1;
        return Math.abs(left -right) < 2 ? Math.max(left, right) + 1 : -1;
    }

}
