package LeetCode1.树;

import LeetCode1.TreeNode;

/**
 * @Author: anzhi
 * @Date: 2021/4/13 17:14
 */
public class 二叉搜索树节点最小距离 {

    int pre;
    int res;

    public int minDiffInBST(TreeNode root) {
        res = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return res;
    }


    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            res = Math.min(res, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }


}
