package LeetCode1.每日一题;

/**
 * @Author: anzhi
 * @Date: 2021/3/30 11:24
 */
public class 搜索二维矩阵 {

    public boolean searchMatrix(int[][] matrix, int target) {
        // 先定位在哪一行
        int m = matrix.length;
        int line = 0;
        for (int i=1; i<m; i++) {
            int index = matrix[i][0];
            if (target < index) {
                line = i - 1;
                break;
            }
        }
        return searchInRow(matrix[line], target);
    }

    public boolean searchInRow(int[] row, int target) {
        int L = 0;
        int R = row.length - 1;
        while (L < R) {
            int mid = (R - L) / 2;
            if (row[mid] == target) {
                return true;
            } else if (row[mid] > target) {
                R = mid - 1;
            } else if (row[mid] < target) {
                L = mid + 1;
            }
        }
//        for (int i=0; i<row.length; i++) {
//            if (row[i] == target) return true;
//        }
        return false;
    }

}
