package LeetCode1;

import java.util.Stack;

/**
 * @Author: anzhi
 * @Date: 2020/10/27 9:22
 */
public class QuickSort {

    public static void main(String[] args) {
        int [] a = {1,6,8,7,3,5,16,4,8,36,13,44};
        QkSort(a, 0, a.length-1);
    }


    /**
     *
     * @param a
     * @param start
     * @param end
     */
    private static void QkSort(int[] a, int start, int end) {
        if (a.length == 0) {
            return;
        }
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int temp = a[left];

        while (left < right) {
            while (left < right && a[right] > temp) {
                right --;
            }
            a[left] = a[right];
            while (left < right && a[left] < temp) {
                left ++;
            }
            a[right] = a[left];
        }
        a[left] = temp;
        QkSort(a, start, left - 1);
        QkSort(a, left + 1, end);

    }



}
