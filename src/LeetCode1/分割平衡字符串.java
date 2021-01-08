package LeetCode1;

/**
 * @Author: anzhi
 * @Date: 2020/11/27 18:11
 */
public class 分割平衡字符串 {

    public int balanceStringSplit(String s) {

        int num = 0;
        int res = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == 'L') {
                num ++;
            } else {
                num --;
            }
            if (num == 0) {
                res ++;
            }
        }
        return res;
    }





}
