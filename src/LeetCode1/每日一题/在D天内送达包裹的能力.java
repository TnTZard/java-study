package LeetCode1.每日一题;

import java.util.Arrays;

/**
 * @Author: anzhi
 * @Date: 2021/4/26 18:06
 */
public class 在D天内送达包裹的能力 {

    public int shipWithinDays(int[] weights, int D) {
        int L = Arrays.stream(weights).max().getAsInt(), R = Arrays.stream(weights).sum();
        while (L < R) {
            int mid = (L + R) / 2;
            int need = 1, cur = 0;
            for (int weight: weights) {
                if (cur + weight > mid) {
                    ++need;
                    cur = 0;
                }
                cur += weight;
            }
            if (need <= D) {
                R = mid;
            } else {
                L = mid + 1;
            }
        }
        return L;
    }



}
