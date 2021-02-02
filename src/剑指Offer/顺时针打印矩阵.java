package 剑指Offer;

import java.util.Arrays;

/**
 * @Author: anzhi
 * @Date: 2021/1/25 16:59
 */
public class 顺时针打印矩阵 {

    /**
     * 1 2  3  4
     * 5 6  7  8
     * 9 10 11 12
     *
     * [0][0] [0][1] [0][2] [0][3]
     * [1][0] [1][1] [1][2] [1][3]
     * [2][0] [2][1] [2][2] [2][3]
     */


    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
//        for (int i=0; i<matrix.length; i++) {
//            for (int j=0; j<matrix[i].length; j++) {
//                System.out.print(matrix[i][j] + " ");
//                if (j == matrix[i].length-1) {
//                    return;
//                }
//            }
//        }
        int[] ans = spiralOrder(matrix);
        Arrays.stream(ans).forEach(i -> System.out.print(i + " "));
    }


    public static int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }

        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        int x = 0;
        int[] res = new int[(right + 1) * (bottom + 1)];
        while (true) {
            for (int i = 1; i <= right; i++) {
                res[x++] = matrix[top][i];
            }
            if (++top > bottom) {break;}
            for (int i = top; i <= bottom; i++) {
                res[x++] = matrix[i][right];
            }
            if (left > --right) {break;}
            for (int i = right; i >= left; i--) {
                res[x++] = matrix[bottom][i];
            }
            if (top > --bottom) {break;}
            for (int i = bottom; i >= top; i--) {
                res[x++] = matrix[i][left];
            }
            if (++left > right) {break;}
        }
        return res;
    }

}
