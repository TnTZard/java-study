package LeetCode1.每日一题;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: anzhi
 * @Date: 2021/3/4 9:30
 */
public class 俄罗斯套娃信封问题 {


    public int maxEnvelopes(int[][] envelopes) {

        int n = envelopes.length;

        // 按宽度升序排序
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });

        // 对高度数组寻找LIS
        int[] height = new int[n];
        for (int i=0; i<n; i++) {
            height[i] = envelopes[i][1];
        }

        return lengthOfLIS(height);
    }

    // 最长递增子序列
    public int lengthOfLIS(int[] nums) {
        int piles = 0, n = nums.length;
        int[] top = new int[n];
        for (int i=0; i<n; i++) {
            int poker = nums[i];
            int left = 0, right = piles;
            // 二分查找插入位置
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] >= poker) {
                    right = mid;
                } else {
                    left = mid + 1;
                }

            }
            if (left == piles) piles++;
            // 把这张牌放到牌堆顶
            top[left] = poker;

        }
        return piles;
    }






}
