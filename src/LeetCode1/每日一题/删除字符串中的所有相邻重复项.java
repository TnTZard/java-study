package LeetCode1.每日一题;

import java.util.Stack;

/**
 * @Author: anzhi
 * @Date: 2021/3/9 11:22
 */
public class 删除字符串中的所有相邻重复项 {

    public static void main(String[] args) {


        String s = "abbaca";
        char[] chars = s.toCharArray();
        System.out.println(removeDuplicates1(s));



    }


    // 解法一: 栈
    public String removeDuplicates(String S) {
        char[] s = S.toCharArray();
        int len = S.length();
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<len; i++) {
            if (stack.isEmpty() || s[i] != stack.peek()) {
                stack.push(s[i]);
            } else {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c: stack) {
            sb.append(c);
        }
        return sb.toString();
    }

    // 解法二：
    public static String removeDuplicates1(String S) {
        char[] cs = S.toCharArray();
        char[] d = new char[S.length()];
        int hh = 0, tt = -1;
        for (char c: cs) {
            if (hh <= tt && d[tt] == c) {
                tt--;
            } else {
                d[++tt] = c;
            }
        }
        return new String(d, 0, tt+1);
    }




}
