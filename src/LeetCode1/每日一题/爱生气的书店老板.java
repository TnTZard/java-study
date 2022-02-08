package LeetCode1.每日一题;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Author: anzhi
 * @Date: 2021/2/23 11:13
 */
public class 爱生气的书店老板 {

    public static void main(String[] args) {
        int m = 1 / 2;
        System.out.println(m);
       int[] customers = {1,0,1,2,1,1,7,5};
       Arrays.sort(customers);
        System.out.println(customers[customers.length - 1]);
//       int[] grumpy = {0,1,0,1,0,1,0,1};
//       int X = 3;
//       maxSatisfied(customers, grumpy, X);
    }
    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
        // 窗口大小
        int length = X;
        // 窗口内元素累加值
        int res = 0, count = 0;
        // 窗口左右边界
        int left = 0, right = X;
        for (int i=0; i<customers.length; i++) {
            // 其实就是找x窗口大小的最大值
            // 找到后返回left和right
            // 将对应的grumpy[i]==1的地方统计customers[i]等于0
            // 最后累加customers数组
            if (grumpy[i] == 0) {
                // 老板生气 顾客不满意  customers[i]=0
                count += customers[i];
                customers[i] = 0;
            }
        }
        while (right < customers.length ) {
            int sum = 0;
            for (int i = left; i < right+1; i++) {
                sum += customers[i];
            }
            res = Math.max(sum, res);
            left ++;
            right ++;
        }
        return res + count;
    }


    public int maxSatisfied2(int[] customers, int[] grumpy, int X) {
        int n = customers.length;
        int ans = 0;
        for (int i=0; i<n; i++) {
            if (grumpy[i] == 0) {
                ans += customers[i];
                customers[i] = 0;
            }
        }
        int max = 0, cur = 0;
        for (int i=0, j=0; i<n; i++) {
            cur += customers[i];
            if (i - j + 1 > X) {
                cur -= customers[j++];
                max = Math.max(max, cur);
            }
        }
        return ans + max;
    }










}
