package LeetCode1.每日一题;
import java.util.*;
/**
 * @Author: anzhi
 * @Date: 2021/3/8 8:53
 */
public class 分割回文串 {
//    boolean[][] f;
//    List<List<String>> ret = new ArrayList<List<String>>();
//    List<String> ans = new ArrayList<>();
//    int n;
//
//
//    public List<List<String>> partition(String s) {
//        n = s.length();
//        f = new boolean[n][n];
//        for (int i=0; i<n; i++) {
//            Arrays.fill(f[i], true);
//        }
//
//        for (int i=n-1; i>=0; --i) {
//            for (int j=i+1; j<n; ++j) {
//                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
//            }
//        }
//        return null;
//    }
//
//    public void dfs(String s, int i) {
//        if (i == n) {
//            ret.add(new ArrayList<>(ans));
//            return;
//        }
//        for (int j=i; j<n; ++j) {
//            if (f[i][j]) {
//                ans.add(s.substring(i, j+1));
//                dfs(s, j+1);
//                ans.remove(ans.size() - 1);
//            }
//        }
//
//    }


    List<List<String>> result = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public void backtracking(String s, int startIndex) {
        // 如果起始位置已经大于s的长度，说明已经找到了一组分割方案
        if (startIndex >= s.length()) {
            result.add(path);
            return;
        }
//        for (int i=startIndex; i<s.length(); i++) {
//            if ()
//        }
    }

    public boolean isPalindrome(String s, int start, int end) {
        return true;
    }


}
