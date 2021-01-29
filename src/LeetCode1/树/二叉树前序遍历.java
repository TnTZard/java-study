package LeetCode1.树;

import LeetCode1.TreeNode;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 前序遍历 : 根->左->右
 * @Author: anzhi
 * @Date: 2021/1/18 8:54
 */
public class 二叉树前序遍历 {

    List<Integer> res = new ArrayList<>();

    // 递归

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }


    // 迭代
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return res;
        }
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return res;
    }

}
