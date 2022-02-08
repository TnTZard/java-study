package LeetCode1.每日一题;

/**
 * @Author: anzhi
 * @Date: 2021/3/8 11:04
 */
public class 最长回文子串 {


    /**
     * 暴力解法
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        // 先转换成字符数组
        char[] charArray = s.toCharArray();
        // 枚举所有长度大于或等于2的子串，依次判断它们是否是回文；
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > maxLen && validPalindromic(charArray, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     * 判断是否是回文串
     * @param chars
     * @param left
     * @param right
     * @return
     */
    public boolean validPalindromic(char[] chars, int left, int right) {
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    /**
     * 动态规划
     */
    public String longestPalindrome1(String s) {
        int n = s.length();
        // dp数组
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int l = 0; l < n; ++l) {
            for (int i = 0; i + l < n; ++i) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans = s.substring(i, i+l+1);
                }
            }
        }
        return ans;
    }







}
