package 剑指Offer;

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，
 * 并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 * @Author: anzhi
 * @Date: 2021/2/1 10:58
 */
public class 缺失的数字 {

    public static void main(String[] args) {

    }

    public static int missingNumber1(int[] nums) {
        // 左子数组 nums[i] = i
        // 右子数组 nums[i] != i
        // 缺失的数字等于 右子数组的首位元素对应的索引x
        // 初始化
        int left = 0, right = nums.length - 1; // 代表区间[i,j]
        // 循环二分
        // 当left<=right时循环(即当闭区间[i,j]为空时跳出)
        while (left <= right) {
            int mid = (left + right) / 2; // 向下取整
            if (nums[mid] == mid) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return left;
    }

    // 遍历遍历着  offer也就遍历到别人那里去了
    public static int missingNumber(int[] nums) {
        for (int i=nums[0]; i<nums.length; i++) {
            if (nums[i] != i+nums[0]) {
                return i+nums[0];
            }
        }
        return 0;
    }






}
