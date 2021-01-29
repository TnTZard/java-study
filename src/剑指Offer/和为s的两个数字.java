package 剑指Offer;

/**
 * @Author: anzhi
 * @Date: 2021/1/28 16:32
 */
public class 和为s的两个数字 {


    public static void main(String[] args) {

    }

    public static int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int s = nums[i] + nums[j];
            if (s < target) i++;
            else if (s > target) j--;
            else return new int[] {nums[i], nums[j]};
        }
        return new int[0];
    }



}
