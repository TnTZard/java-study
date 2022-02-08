package LeetCode1;

import java.util.*;

/**
 * @author xiezq1
 * @version 1.0.0
 * @date 2022/1/30 10:52
 */
public class 两句话中的不常见单词 {

    public static void main(String[] args) {
        String s1 = "this apple is sweet";
        String s2 = "this apple is sour";
        uncommonFromSentences(s1, s2);
    }

    private static String[] uncommonFromSentences(String s1, String s2) {
        List<String> res = new ArrayList<>();
        String str = s1 + " " + s2;
        String[] s = str.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String t : s) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                res.add(entry.getKey());
            }
        }
        return res.toArray(new String[0]);
    }

}
