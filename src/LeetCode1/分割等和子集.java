package LeetCode1;

/**
 * 416. 分割等和子集
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 示例 1：
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 *
 * 示例 2：
 *
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 * @Author: anzhi
 * @Date: 2021/5/18 14:07
 */
public class 分割等和子集 {


    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        // 如果是奇数 就不符合要求
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum / 2;
        // 创建二维数组
        boolean[][] dp = new boolean[len][target + 1];

        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {

            }
        }
        return true;
    }

}
