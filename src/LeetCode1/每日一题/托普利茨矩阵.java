package LeetCode1.每日一题;

/**
 * @Author: anzhi
 * @Date: 2021/2/23 14:40
 */
public class 托普利茨矩阵 {


    public boolean isToeplitzMatrix(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        // 每一层的前
        for (int i=0; i<row-1; i++) {
            for (int j=0; j<column-1; j++) {
                if (matrix[i][j] != matrix[i+1][j+1]) {
                    return false;
                }
            }
        }
        return true;
    }



}
