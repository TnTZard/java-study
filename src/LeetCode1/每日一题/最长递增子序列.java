package LeetCode1.每日一题;

import java.util.Arrays;

/**
 * @Author: anzhi
 * @Date: 2021/3/4 9:57
 */
public class 最长递增子序列 {

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 21, 18};
        System.out.println(lengthOfLIS1(nums));
    }

    // 动态规划
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for (int i=0; i<nums.length; i++) {
            for (int j=0; j<i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }


    // 动态规划 + 二分查找
    public static int lengthOfLIS1(int[] nums) {

        int[] tails = new int[nums.length];
        int res = 0;
        for (int num: nums) {
            int i = 0, j = res;
            while (i < j) {
                int m = (i + j) / 2;
                if (tails[m] < num) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            tails[i] = num;
            if (res == j) res++;
        }
        return res;
    }



}
