package LeetCode1;

import java.util.PriorityQueue;

/**
 * @author xiezq1
 * @version 1.0.0
 * @date 2022/2/7 11:14
 */
public class 最长快乐字符串 {

    public static void main(String[] args) {
        System.out.println(longestDiverseString(1, 1, 7));
    }

    public static String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        if (a > 0) queue.add(new int[]{0, a});
        if (b > 0) queue.add(new int[]{1, b});
        if (c > 0) queue.add(new int[]{2, c});
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int n = sb.length();
            if (n >= 2 && sb.charAt(n - 1) - 'a' == cur[0] && sb.charAt(n - 2) - 'a' == cur[0]) {
                if (queue.isEmpty()) break;
                int[] poll = queue.poll();
                sb.append((char) (poll[0] + 'a'));
                if (--poll[1] != 0) queue.add(poll);
                queue.add(cur);
            } else {
                sb.append((char) (cur[0] + 'a'));
                if (--cur[1] != 0) queue.add(cur);
            }
        }
        return sb.toString();
    }
}
