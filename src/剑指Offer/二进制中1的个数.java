package 剑指Offer;

/**
 * @Author: anzhi
 * @Date: 2021/1/28 11:51
 */
public class 二进制中1的个数 {

    public static void main(String[] args) {

    }

    public static int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            // 无符号右移一位
            n >>>= 1;
        }
        return res;
    }


    public static int hammingWeight1(int n) {
        int res = 0;
        while (n != 0) {
            res ++ ;
            n &= (n - 1);
        }
        return res;
    }

}
