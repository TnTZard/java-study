package 剑指Offer;

/**
 * @Author: anzhi
 * @Date: 2021/1/28 11:24
 */
public class 剪绳子 {


    public static void main(String[] args) {
        System.out.println(cuttingRope1(6));
    }

    // 数学
    public static int cuttingRope(int n) {
        if (n <= 1) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;
        int number;
        int count = 1;
        while (n >= 5) {
            count *= 3;
            n -=3;
        }
        return count * n;
    }

    // 动态规划

    public static int cuttingRope1(int n) {
        int[] dp = new int[n + 1];
        for (int i=2; i<=n; i++) {
            for (int j=1; j<i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }




}
