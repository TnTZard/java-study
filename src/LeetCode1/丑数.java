package LeetCode1;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 *
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 *
 *
 *
 * @Author: anzhi
 * @Date: 2021/5/17 14:37
 */
public class 丑数 {

    public static void main(String[] args) {
        nthUglyNumber(15);
    }

    public static int nthUglyNumber(int n) {
        // 只包含质因子 2/3/5
        int dp[] = new int[n];
        int a = 0, b = 0, c = 0;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            //System.out.println("第" + i + "趟" + " n2=" + n2 + " n3=" + n3 + " n5=" + n5);
            dp[i] = Math.min(Math.min(n2, n3), n5);
            //System.out.println("最小的丑数=" + dp[i]);
            if (dp[i] == n2) a++;
            if (dp[i] == n3) b++;
            if (dp[i] == n5) c++;
        }
        return dp[n - 1];
    }

    public static int nthUglyNumber1(int n) {
        int[] factors = {2, 3, 5};
        Set<Long> seen = new HashSet<>();
        PriorityQueue<Long> heap = new PriorityQueue<>();
        seen.add(1L);
        heap.offer(1L);
        int ugly = 0;
        for (int i=0; i<n; i++) {

        }
        return 0;
    }













}
