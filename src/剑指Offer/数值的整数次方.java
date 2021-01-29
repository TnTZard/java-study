package 剑指Offer;

/**
 * @Author: anzhi
 * @Date: 2021/1/28 14:11
 */
public class 数值的整数次方 {

    public static void main(String[] args) {
        //System.out.println(-2147483648 > 0);
        //System.out.println(myPow(2.00, -2147483648));
        System.out.println(myPow1(2.0, 10));
    }

    public static double myPow(double x, int n) {
        if (n == 0 || x == 1) return 1;
        double res = x;
        long count = (n > 0)? n : -n;
        while (count > 1) {
            res *= x;
            count--;
        }
        return n > 0? res: 1/res;
    }

    public static double myPow1(double x, int n) {
       if (x == 0) return 0;
       long b = n;
       double res = 1.0;
       if (b < 0) {
           x = 1 / x;
           b = -b;
       }
       while (b > 0) {
           if ((b & 1) == 1) res*=x;
           x *= x;
           b >>= 1;
       }
       return res;
    }




}
