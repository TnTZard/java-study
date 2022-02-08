package LeetCode1.每日一题;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.*;

/**
 * @Author: anzhi
 * @Date: 2021/3/31 9:32
 */
public class 子集II {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtracking(nums, 0, false);
        return res;
    }

    public void backtracking(int[] nums, int i, boolean choosePre) {
        if (i == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[i]);
        backtracking(nums, i+1, true);
        path.remove(path.size() - 1);
        if (choosePre && nums[i - 1] == nums[i]) return;
        backtracking(nums, i+1, false);
    }




}
