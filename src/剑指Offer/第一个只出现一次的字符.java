package 剑指Offer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: anzhi
 * @Date: 2021/1/29 14:37
 */
public class 第一个只出现一次的字符 {

    public static void main(String[] args) {

    }

    public static char firstUniqChar(String s) {
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (s.indexOf(c) == i && s.indexOf(c, i+1) == -1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }

    // 哈希表
    public static char firstUniqChar1(String s) {
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for (char c: sc) {
            dic.put(c, !dic.containsKey(c));
        }
        for (char c: sc) {
            if (dic.get(c)) return c;
        }
        return ' ';
    }

    public static char firstUniqChar2(String s) {
        Map<Character, Boolean> dic = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        for (char c: sc) {
            dic.put(c, !dic.containsKey(c));
        }
        for (Map.Entry<Character, Boolean> d: dic.entrySet()) {
            if (d.getValue()) return d.getKey();
        }
        return ' ';
    }

}
