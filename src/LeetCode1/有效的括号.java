package LeetCode1;

import java.util.*;

/**
 * @Author: anzhi
 * @Date: 2021/3/11 19:24
 */
public class 有效的括号 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i=0; i<s.length(); i++) {
            if (!stack.isEmpty()) {
                if (chars[i] == ')') {
                    if (stack.pop() != '(') {
                        return false;
                    }
                } else if (chars[i] == '}') {
                    if (stack.pop() != '{') {
                        return false;
                    }
                } else if (chars[i] == ']') {
                    if (stack.pop() != '[') {
                        return false;
                    }
                }
            }
            stack.push(chars[i]);
        }
        return true;
    }




}
