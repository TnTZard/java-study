package LeetCode1.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: anzhi
 * @Date: 2021/1/8 16:23
 */
public class 旋转数组 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums, k);
    }


    public static void rotate(int[] nums, int k) {
        List<Integer> tailList = new LinkedList<>();
        List<Integer> allList = new LinkedList<>();
        if (k==0) {
            return;
        }
        if (k>nums.length) {
            k%=nums.length;
        }
        for (int i=nums.length-k; i<nums.length; i++) {
            tailList.add(nums[i]);
        }
        allList.addAll(tailList);
        for (int i=0; i<nums.length-k; i++) {
            allList.add(nums[i]);
        }
        for(int i=0; i<allList.size(); i++) {
            nums[i] = allList.get(i);
        }
    }


    public static void rotate1(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i+k)%n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }



    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }


}
