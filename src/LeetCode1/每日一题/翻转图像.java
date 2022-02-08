package LeetCode1.每日一题;

import java.util.LinkedHashMap;

/**
 * @Author: anzhi
 * @Date: 2021/2/24 15:03
 */
public class 翻转图像 {


    public static void main(String[] args) {
        int[] nums = {1,1,0};
        int index = nums.length - 1;
        for (int i=0; i<nums.length/2; i++) {
            int temp;
            temp = nums[i];
            nums[i] = nums[index - i];
            nums[index - i] = temp;
        }

    }

    public int[][] flipAndInvertImage(int[][] A) {
        for (int i=0; i<A.length; i++) {
            int index = A[i].length - 1;
            // 先翻转
            for (int j=0; j<A[i].length/2; j++) {
                int temp;
                temp = A[i][j];
                A[i][j] = A[i][index - j];
                A[i][index - j]= temp;
            }
            // 再反转
            for (int a: A[i]) {
                if (a==0) a=1;
                if (a==1) a=0;
            }
        }
        return A;
    }



}
