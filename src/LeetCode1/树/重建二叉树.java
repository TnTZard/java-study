package LeetCode1.树;

import LeetCode1.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: anzhi
 * @Date: 2021/1/11 20:04
 */
public class 重建二叉树 {


    public static TreeNode buildTree(int[] preorder, int[] inorder) {
//        // 把前序遍历的值和中序遍历的值放到list中
//        List<Integer> preorderList = new ArrayList<>();
//        List<Integer> inorderList = new ArrayList<>();
//        for (int i=0; i<preorder.length; i++) {
//            preorderList.add(preorder[i]);
//            inorderList.add(inorder[i]);
//        }
//        return helper(preorderList, inorderList);


        if (preorder == null || preorder.length == 0) {
            return null;
        }

        Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        int length = preorder.length;
        for (int i=0; i<length; i++) {
            indexMap.put(inorder[i], i);
           // TreeNode root = buildTree(preorder, 0, length-1, inorder, 0, length-1, indexMap);
        }

        return null;
    }


    public static TreeNode buildTree(int[] preorder, int preorderStart, int preorderEnd, int[] inorder) {
       return null;
    }


    public static TreeNode helper(List<Integer> preorderList, List<Integer> inorderList) {
        if (inorderList.size() == 0) {
            return null;
        }
        // 前序遍历的第一个值就是根节点
        int rootVal = preorderList.remove(0);
        // 创建根节点
        TreeNode root = new TreeNode(rootVal);
        // 查看根节点在中序遍历中的位置
        int mid = inorderList.indexOf(rootVal);
        root.left = helper(preorderList, inorderList.subList(0, mid));
        root.right = helper(preorderList, inorderList.subList(mid + 1, inorderList.size()));
        return root;
    }




}
