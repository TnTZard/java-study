package 剑指Offer;

/**
 * @Author: anzhi
 * @Date: 2020/11/27 18:26
 */
public class 左旋转字符串 {

    public String reverseLeftWords(String s, int n) {
        StringBuilder stringBuilder = new StringBuilder(s);
        if ( n > s.length()) {
            return stringBuilder.reverse().toString();
        }
        String a = s.substring(0, n);
        String b = s.substring(n);
        return b + a;
    }



}
