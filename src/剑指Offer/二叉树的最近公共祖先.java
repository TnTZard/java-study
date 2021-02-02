package 剑指Offer;

import LeetCode1.TreeNode;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: anzhi
 * @Date: 2021/2/1 17:00
 */
public class 二叉树的最近公共祖先 {


    public static void main(String[] args) {

    }


    /**
     *
     *
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (null != root) {
            if (root.val < p.val && root.val < q.val) root = root.right;
            else if (root.val > p.val && root.val > q.val) root = root.left;
            else break;
        }
        return root;
    }


}
