package 剑指Offer.树;
/**
 * @Author: anzhi
 * @Date: 2020/12/3 15:41
 */
public class 二叉树的镜像 {


    public static TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }




}
