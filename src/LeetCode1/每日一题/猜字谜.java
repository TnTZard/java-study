//package LeetCode1.每日一题;
//
//import java.util.*;
//
///**
// * @Author: anzhi
// * @Date: 2021/2/26 10:40
// */
//public class 猜字谜 {
//
//    // 单词word中包含谜面puzzle的第一个字母
//    // 单词word中的每一个字母都可以在谜面puzzle中找到
//    public static void main(String[] args) {
//
//        Map<Integer, Integer> map = new HashMap<>();
//        map.containsKey()
//    }
//
//    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
//        int[] res = new int[puzzles.length];
//        List<Integer> result = new ArrayList<>();
//        for (int i=0; i< puzzles.length; i++) {
//            String puzzle = puzzles[i];
//            String firstWord = String.valueOf(puzzle.toCharArray()[0]);
//            for (int j=0; j<words.length; j++) {
//                boolean flag1 = words[j].contains(firstWord);
//                // 单词word中的每一个字母都可以在谜面puzzle中找到
//                boolean flag2 = true;
//                char[] chars = words[j].toCharArray();
//                for (char c: chars) {
//                    if (!puzzle.contains(String.valueOf(c))) {
//                        flag2 = false;
//                        break;
//                    }
//                }
//                if (flag1 && flag2) {
//                    res[i] ++;
//                }
//            }
//        }
//
//        for(int i: res) {
//            result.add(i);
//        }
//        return result;
//    }
//
//
//    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
//        // 预处理出所有的word所对应的二进制数值
//        List<Integer> list = new ArrayList<>();
//        for (String word: words) {
//
//            list.add(getBin(w));
//        }
//    }
//
//    int getBin(String word) {
//        int t = 0;
//        char[] cs = word.toCharArray();
//        for (char c: cs) {
//            int u = c - 'a';
//            if ((t >> u&1) == 0) {
//                t+=1 << u;
//            }
//        }
//    }
//
//
//
//}
//
//
//
