package 剑指Offer;

import java.util.*;
/**
 * @Author: anzhi
 * @Date: 2021/2/1 11:26
 */
public class 翻转单词顺序 {

    public static void main(String[] args) {

    }

    // 双指针
    public static String reverseWords(String s) {
        // 倒序遍历字符串s  记录单次左右索引边界left,right
        // 每确定一个单词的边界，则将其添加至单词列表res
        // 最终，将单词列表拼接为字符串，并返回
        s = s.trim(); // 删除首尾空格
        int right = s.length() - 1, left = right;
        StringBuilder res = new StringBuilder();
        while (left >= 0) {
            // 搜索首个空格
            while (left >= 0 && s.charAt(left) != ' ') { left--; }
            // 添加单词
            res.append(s.substring(left + 1, right + 1) + " ");
            // 跳过单词间空格
            while (left >= 0 && s.charAt(left) == ' ') { left--; }
            // right指向下个单词的尾字符
            right = left;
        }
        return res.toString().trim();
    }


}
