package 剑指Offer;

/**
 * @Author: anzhi
 * @Date: 2021/1/27 17:21
 */
public class 旋转数组的最小数字 {

    public static void main(String[] args) {
        int[] nums = {2,2,2,0,1};
        System.out.println(minArray(nums));
        System.out.println(3 >> 1);
    }
    public static int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int mid = ((right - left) >> 1) + 1;
            // 只要右边比左边大，那右边一定是有序数组
            if (numbers[right] > numbers[mid]) {
                right = mid;
            } else if (numbers[right] < numbers[mid]) {
                left = mid + 1;
            } else {
                right --;
            };
        }
        return numbers[left];
    }






}
