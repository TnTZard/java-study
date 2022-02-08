package jvm.类;

/**
 * @Author: anzhi
 * @Date: 2021/4/19 17:32
 */
public class Test {

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int j = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        System.out.println(nums);
    }


}
