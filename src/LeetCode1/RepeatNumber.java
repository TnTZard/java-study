package LeetCode1;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: anzhi
 * @Date: 2020/11/3 9:33
 */
public class RepeatNumber {
    public static void main(String[] args) {
        //int[] ary = {0, 1, 2, 3, 4, 11, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int[] ary = {2, 3, 1, 0, 2, 5, 3};
        long startTime = System.nanoTime();
        String s1 = "";
        //s1.replace()//获取开始时间
        System.out.println(findRepeatNumber(ary));    //测试的代码段
        long endTime = System.nanoTime();    //获取结束时间
        System.out.println("程序运行时间：" + (endTime - startTime) + "ns");
    }
    public static int findRepeatNumber(int[] nums) {
        int temp;
        for (int i=0; i<nums.length; i++) {
            while(nums[i]!=i){
                if(nums[i]==nums[nums[i]]){
                    return nums[i];
                }
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }

    public static int findRepeatNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int repeat = -1;
        for (int num: nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }

}
