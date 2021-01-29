package 剑指Offer;

/**
 * @Author: anzhi
 * @Date: 2021/1/27 11:49
 */
public class 青蛙跳台阶问题 {

    public static void main(String[] args) {
        System.out.println(numWays(7));
    }

    // 动态规划
    public static int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-2] + dp[i - 1]) % 1000000007;
        }
        return dp[n];
    }

    // 优化
    public static int numWays1(int n) {
        int a=1, b=1, sum;
        for (int i=0; i < n; i++) {
            sum = (a+b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

}
