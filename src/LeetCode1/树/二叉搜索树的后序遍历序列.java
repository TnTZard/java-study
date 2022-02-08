package LeetCode1.树;

import java.util.Stack;

/**
 * @Author: anzhi
 * @Date: 2021/4/14 10:20
 */
public class 二叉搜索树的后序遍历序列 {


    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    public boolean recur(int[] postorder, int i, int j) {
        //
        if (i >= j) return true;
        int p = i;
        while (postorder[p] < postorder[i]) p++;
        int m = p;
        while (postorder[p] < postorder[j]) p++;
        return p == j && recur(postorder, i, m-1) && recur(postorder, m, j-1);
    }

    public boolean verifyPostorder1(int[] postorder) {
        return false;
    }


    public static void main(String[] args) {

    }






}
