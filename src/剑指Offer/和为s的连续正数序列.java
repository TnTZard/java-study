package 剑指Offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: anzhi
 * @Date: 2021/1/29 10:50
 */
public class 和为s的连续正数序列 {

    public static void main(String[] args) {

    }

    // 滑动窗口法
    public int[][] findContinuousSequence(int target) {
        // 左边界 i=1, 有边界 j=2, 更新元素和s
        int i = 1, j = 2, s = 3;
        List<int[]> res = new ArrayList<>();
        while (i < j) {
            if (s == target) {
                int[] ans = new int[j - i + 1];
                for (int k = i; k <= j; k++) {
                    ans[k - i] = k;
                }
                res.add(ans);
            }
            // 当和大于target时，向右移动左边界 i = i + 1, 并更新元素和 s
            if (s >= target) {
                s -= i;
                i++;
            } else {
                j++;
                s += j;
            }
        }
        return res.toArray(new int[res.size()][]);
    }




}
