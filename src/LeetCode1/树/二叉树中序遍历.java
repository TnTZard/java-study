package LeetCode1.树;



import LeetCode1.TreeNode;

import java.util.*;

/**
 * 二叉树中序遍历: 左->根->右
 * @Author: anzhi
 * @Date: 2021/1/18 20:02
 */
public class 二叉树中序遍历 {
//
//
//    List<Integer> res = new ArrayList<>();
//    public List<Integer> inorderTraversal(TreeNode root) {
//        if (root == null) {
//            return res;
//        }
//        dfs(root);
//        return res;
//    }
//
//    public void dfs(TreeNode root) {
//        if (root == null) {
//          return;
//        }
//        dfs(root.left);
//        res.add(root.val);
//        dfs(root.right);
//    }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    /**
     * Morris 中序遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode predecessor = null;
        while (root != null) {
            if (root.left != null) {
                // predecessor 节点就是当前root节点向左走一步，然后一直向右走到无法走为止
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }
                // 让 predecessor 的右指针指向root， 继续遍历左子树
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                } else {
                    // 说明左子树已经访问完了，我们需要断开连接
                    res.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }
            } else {
                // 如果没有左孩子，则直接访问右孩子
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }

}
