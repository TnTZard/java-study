package LeetCode1.zhousai;

import java.util.Arrays;

import java.util.*;

/**
 * @author xiezq1
 * @version 1.0.0
 * @date 2021/10/12 15:35
 */
public class 将数组分成两个数组并最小化数组和的差 {

    public int minimumDifference(int[] nums) {

        int n = nums.length / 2;
        int sum = Arrays.stream(nums).sum();
        int[] A = new int[n], B = new int[n];
        List<List<Integer>> X = new ArrayList<>(), Y = new ArrayList<>();

        // 分割两个子集
        for (int i=0; i<=n; i++) {
            if (i < n) {
                A[i] = nums[i];
                B[i] = nums[i + n];
            }
            X.add(new ArrayList<>());
            Y.add(new ArrayList<>());
        }

        for (int mask = 0; mask < 1 << n; mask++) {

        }

        return 0;
    }

}
