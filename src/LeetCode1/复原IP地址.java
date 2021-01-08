package LeetCode1;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: anzhi
 * @Date: 2020/11/18 13:45
 */
public class 复原IP地址 {

    static final int SEG_COUNT = 4;
    List<String> ans = new ArrayList<>();
    int[] segments = new int[SEG_COUNT];



    public static void main(String[] args) {

    }

    public List<String> restoreIpAddresses(String s) {
        return null;
    }

    public void dfs(String s, int segId, int segStart) {

        if (segId == SEG_COUNT) {
            if (segStart == s.length()) {
                StringBuffer ipAddr = new StringBuffer();

            }
        }






    }







}
