package LeetCode1.zhousai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author xiezq1
 * @version 1.0.0
 * @date 2021/10/11 17:02
 */
public class 获取单值网格的最小操作数 {

    public static void main(String[] args) {
        int x = 250254108;
        System.out.println(x);
    }

    public int minOperations(int[][] grid, int x) {
        int res = -1;

        // 求中位数
        int m = grid.length;
        if (m == 1) return 0;
        int n = grid[0].length;
        List<Integer> total = new ArrayList<>();
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                total.add(grid[i][j]);
            }
        }
        Collections.sort(total);
        int size = total.size();
        int mid;
        if (size % 2 == 0) {
            mid = total.get((int)size/2);
        } else {
            mid = total.get(size/2 - 1);
            System.out.println(size/2 - 1);
        }
        System.out.println(mid);
        for (Integer num : total) {
            int gap = Math.abs(num - mid);
            if (gap % x == 0) {
                res += (gap / x);
            } else {
                return -1;
            }
        }
        return res;
    }

}
