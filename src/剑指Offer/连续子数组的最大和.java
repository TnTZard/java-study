package 剑指Offer;

/**
 * @Author: anzhi
 * @Date: 2021/1/29 14:58
 */
public class 连续子数组的最大和 {

    public static void main(String[] args) {

    }

    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }


    // 基础动态规划
    public static int maxSubArray1(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i=1; i< nums.length; i++) {
            if (dp[i-1] > 0) {
                dp[i] = dp[i-1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i< dp.length; i++) {
            if (dp[i] > max) max = dp[i];
        }
        return max;
    }



}
