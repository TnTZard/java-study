package LeetCode1.树;

import LeetCode1.TreeNode;

import java.util.*;

/**
 * @Author: anzhi
 * @Date: 2021/4/14 17:54
 */
public class 二叉树中和为某一值的路径 {

    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        recur(root, target);
        return null;
    }


    public void recur(TreeNode root, int target) {
        if (root == null) return;
        path.add(root.val);
        // 目标值更新
        target -= root.val;
        // 路径记录
        if (root.left == null && root.right == null && target == 0) {
            res.add(new LinkedList<>(path));
        }
        recur(root.left, target);
        recur(root.right, target);
        path.removeLast();
    }



}
