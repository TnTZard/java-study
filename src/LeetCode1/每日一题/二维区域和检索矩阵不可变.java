package LeetCode1.每日一题;

/**
 * @Author: anzhi
 * @Date: 2021/3/2 9:21
 */
public class 二维区域和检索矩阵不可变 {



    class NumMatrix {

        // 二维前缀和

        // sum[i+1][j+1] = sumRegion(0,0,i,j)
        private int[][] sum;

        public NumMatrix(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) return;
            int rows = matrix.length;
            int cols = matrix[0].length;
            sum = new int[rows+1][cols+1];
            for (int i = 0; i < rows; i++) {
                for (int j =0; j < cols; j++) {
                    sum[i+1][j+1] = sum[i+1][j] + sum[i][j+1] - sum[i][j] + matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return sum[row2 + 1][col2 + 1] - sum[row1][col2 + 1] - sum[row2 + 1][col1] + sum[row1][col1];
        }



    }






}
