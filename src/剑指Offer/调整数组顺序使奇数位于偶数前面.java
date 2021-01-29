package 剑指Offer;

/**
 * @Author: anzhi
 * @Date: 2021/1/29 11:29
 */
public class 调整数组顺序使奇数位于偶数前面 {

    public static void main(String[] args) {

    }

    //x&1 位运算 等价于 x%2 取余运算，即皆可用于判断数字奇偶性


    public static int[] exchange(int[] nums) {
        // 弄个双指针 指针i从左向右寻找偶数  指针j从右向左寻找奇数
        int i = 0, j = nums.length -1, tmp;
        // 当两个指针相遇时
        while (i < j) {
            while (i < j && ((nums[i]&1) == 1)) i++;
            while (i < j && ((nums[j]&1) == 0)) j--;
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }





}
