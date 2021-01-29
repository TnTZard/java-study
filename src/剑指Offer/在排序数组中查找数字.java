package 剑指Offer;

/**
 * @Author: anzhi
 * @Date: 2021/1/29 18:08
 */
public class 在排序数组中查找数字 {


    public static void main(String[] args) {

    }

    public static int search(int[] nums, int target) {
        // 排序数组
        // 中间数
        int mid = nums[nums.length/2];
        int count = 0;
        for (int i=0; i < nums.length; ++i) {
            if (nums[i] == target) {
                count++;
            }
            if (nums[i] > target) break;
        }
        return count;
    }

    /**
     * 排序数组中的搜索问题，首先想到 二分法 解决。
     *
     * **/
    public static int search1(int[] nums, int target) {
        // 搜索有边界 right
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i+j)/2;
            if (nums[m] <= target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        int right = i;
        // 若数组中无target，则提前返回
        if (j >= 0 && nums[j] != target) return 0;
        // 搜索左边界left
        i = 0; j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] < target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        int left = j;
        return right - left - 1;
    }


}
