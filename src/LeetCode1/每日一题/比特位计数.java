package LeetCode1.每日一题;

/**
 * @Author: anzhi
 * @Date: 2021/3/3 10:16
 */
public class 比特位计数 {


    public int[] countBits(int num) {
        int[] res = new int[num+1];
        res[0] = 0;
        for (int i=1; i<=num; i++) {
            // 计算二进制1的个数
            if (i % 2 == 1) {
                // 奇数
                res[i] = res[i-1] + 1;
            } else {
                // 偶数
                res[i] = res[i/2];
            }
        }
        return res;
    }





}
