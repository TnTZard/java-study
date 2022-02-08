package LeetCode1.回溯;

import java.util.*;

/**
 * @Author: anzhi
 * @Date: 2021/3/31 10:47
 */
public class 全排列 {

    public List<List<Integer>> permute(int[] nums) {

        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) return res;

        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();
        // 回溯
        backtracking(nums, len, 0, path, used, res);
        return res;
    }

    private void backtracking(int[] nums, int len, int depth, List<Integer> path, boolean[] used, List<List<Integer>> res) {
        // 如果递归的层数等于数组的长度
        if (depth == len) {
            // 添加对path的拷贝
            res.add(new ArrayList<>(path));
            return;
        }



    }


}
