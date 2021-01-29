package 剑指Offer;

/**
 * @Author: anzhi
 * @Date: 2021/1/28 17:02
 */
public class 数组中出现次数超过一半的数字 {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        majorityElement(a);
    }



    public static int majorityElement(int[] nums) {
        int x = 0, votes = 0;
        for (int num: nums) {
           if (votes == 0) x = num;
           votes += (num == x ? 1: -1);
        }
        return x;
    }


}
