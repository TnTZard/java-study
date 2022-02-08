package LeetCode1.困难;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author xiezq1
 * @version 1.0.0
 * @date 2022/2/8 13:50
 */
public class 网格照明 {

    public static void main(String[] args) {

        int n = 5;
        int[][] lamps = {{0,0}, {4,4}};
        int[][] queries = {{0,0}};

        gridIllumination(n, lamps, queries);
    }

    static int[][] dirs = {{0, 0}, {0, -1}, {0, 1}, {-1, 0}, {-1, -1}, {-1, 1}, {1, 0}, {1, -1}, {1, 1}};
    public static int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        long N = n;
        // 点亮灯  行、列、对角线都被点亮
        Map<Integer, Integer> row = new HashMap<>(), col = new HashMap<>();
        Map<Integer, Integer> left = new HashMap<>(), right = new HashMap<>();
        Set<Long> set = new HashSet<>();
        // 先亮灯
        for (int[] lamp : lamps) {
            // 灯的横坐标和纵坐标
            int x = lamp[0], y = lamp[1];
            int a = x + y, b = x - y;
            if (set.contains(x * N + y)) continue;
            increment(row, x);
            increment(col, y);
            increment(left, a);
            increment(right, b);
            set.add(x * N + y);
        }
        // 再查询
        int m = queries.length;
        int[] ans = new int[m];
        // 查询第一个格子  第二个格子 ……
        for (int i = 0; i < m; i++) {
            int[] q = queries[i];
            int x = q[0], y = q[1];
            int a = x + y, b = x - y;
            if (row.containsKey(x) || col.containsKey(y) || left.containsKey(a) || right.containsKey(b)) {
                ans[i] = 1;
            }
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                int na = nx + ny, nb = nx - ny;
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (set.contains(nx * N + ny)) {
                    set.remove(nx * N + ny);
                    decrement(row, nx);
                    decrement(col, ny);
                    decrement(left, na);
                    decrement(right, nb);
                }
            }
        }
        return ans;
    }

    static void increment(Map<Integer, Integer> map, int key) {
        map.put(key, map.getOrDefault(key, 0) + 1);
    }

    static void decrement(Map<Integer, Integer> map, int key) {
        if (map.get(key) == 1) map.remove(key);
        else map.put(key, map.get(key) - 1);
    }

}
