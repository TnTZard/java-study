package LeetCode1;

/**
 * @Author: anzhi
 * @Date: 2020/11/5 20:49
 */
public class Fib {


    public static void main(String[] args) {
        System.out.println(fib(44));
    }

    public static int fib(int n) {
        if (n==0) return 0;
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i=2; i<dp.length; i++) {
            dp[i] = dp[i-1] + dp[i-2];
            dp[i] %= 1000000007;
        }
        return dp[n];
    }



}
