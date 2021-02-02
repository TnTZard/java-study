package 剑指Offer;

import LeetCode1.TreeNode;

/**
 * @Author: anzhi
 * @Date: 2021/2/1 15:46
 */
public class 二叉搜索树的第k大节点 {


    public static void main(String[] args) {

    }

    /**
     * 关键词：二叉搜索树
     * 特性：二叉搜索树的中序遍历为递增序列
     */

    // 类变量维护k，res
    int res, k;
    public int kthLargest(TreeNode root, int k) {
        // 终止条件：当节点root为空（越过叶节点）
        this.k = k;
        // 递归右子树
        dfs(root);
        //
        return res;
    }


    // 打印中序遍历倒序
    void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        if (k == 0) return;
        if (--k == 0) res = root.val;
        //System.out.println(root.val);
        dfs(root.left);
    }



}
