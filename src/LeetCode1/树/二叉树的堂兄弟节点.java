package LeetCode1.树;

import LeetCode1.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: anzhi
 * @Date: 2021/5/17 11:30
 */
public class 二叉树的堂兄弟节点 {


    public boolean isCousins(TreeNode root, int x, int y) {
        int[] xi = dfs(root, null, 0, x);
        int[] yi = dfs(root, null, 0, y);
        return (xi[1] == yi[1]) && (xi[0] != yi[0]);
    }

    /**
     * DFS
     * @param root
     * @param father
     * @param depth
     * @param t
     * @return
     */
    public int[] dfs(TreeNode root, TreeNode father, int depth, int t) {
        if (root == null) return new int[]{-1, -1};
        if (root.val == t) {
            return new  int[]{father != null ? father.val : 1, depth};
        }
        int[] l = dfs(root.left, root, depth+1, t);
        if (l[0] != -1) return l;
        return dfs(root.right, root, depth+1, t);
    }

    /**
     * BFS
     * @param root
     * @param t
     * @return
     */
    public int[] bfs(TreeNode root, int t) {
        Deque<Object[]> d = new ArrayDeque<>();
        d.addLast(new Object[]{root, null, 0});
        while (!d.isEmpty()) {
            int size = d.size();
            while (size-- > 0) {
                Object[] poll = d.pollFirst();
                TreeNode cur = (TreeNode) poll[0], father = (TreeNode) poll[1];
                int depth = (Integer) poll[2];
                if (cur.val == t) return new int[]{father != null ? father.val : 0, depth};
                if (cur.left != null) d.addLast(new Object[]{cur.left, cur, depth + 1});
                if (cur.right != null) d.addLast(new Object[]{cur.right, cur, depth + 1});
            }
        }
        return new int[]{-1, -1};
    }




}
