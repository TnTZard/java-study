package LeetCode1;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author xiezq1
 * @version 1.0.0
 * @date 2022/1/30 11:21
 */
public class 地图中的最高点 {

    public static void main(String[] args) {

    }


    public int[][] highestPeak(int[][] isWater) {

        int m = isWater.length, n = isWater[0].length;
        int[][] ans = new int[m][n];
        Deque<int[]> d = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    d.addLast(new int[]{i, j});
                }
                // 没被访问过的陆地起始为 -1
                ans[i][j] = isWater[i][j] == 1 ? 0 : 1;
            }
        }
        // 方向
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!d.isEmpty()) {
            int[] info = d.pollFirst();
            int x = info[0], y = info[1];
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                // 下一个点出界了
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                // 下一个点被访问过了
                if (ans[nx][ny] != -1) continue;
                ans[nx][ny] = ans[x][y] + 1;
                // 作为下一层遍历的元素入队
                d.addLast(new int[]{nx, ny});
            }
        }
        return ans;
    }



}
