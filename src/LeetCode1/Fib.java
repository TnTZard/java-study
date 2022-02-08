package LeetCode1;

import java.util.StringJoiner;

/**
 * @Author: anzhi
 * @Date: 2020/11/5 20:49
 */
public class Fib {


    public static void main(String[] args) {
//        int result = 0;
//        System.out.println(result);
        String a = "A,B";
        String[] arr = a.split(",");
        String result = "";
        for (String str: arr) {
           result = a.replace("A", "哈哈");
            result = result.replace("B", "嘻嘻");
        }
        System.out.println(result);
//        String s = "11223";
//
//        System.out.println(fib(44));
//
//        StringJoiner stringJoiner = new StringJoiner(",");
//        stringJoiner.add("hello");
//        stringJoiner.add("hello");
//        System.out.println(stringJoiner.toString());
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
