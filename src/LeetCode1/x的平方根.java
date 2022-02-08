package LeetCode1;

/**
 * @Author: anzhi
 * @Date: 2021/4/20 17:24
 */
public class x的平方根 {


    public static void main(String[] args) {
        System.out.println(mySqrt(8));
        System.out.println(3 / 2);
    }

    public static int mySqrt(int x) {
        int L = 0;
        int R = x;
        while (L < R) {
            int mid = (L + R + 1) / 2;
            if ( (long) mid*mid > x) {
                R = mid - 1;
            } else {
                L = mid;
            }
        }
        return L;
    }


    public static int mySqrt1(int x) {
        if (x == 0) {
            return 0;
        }
        double C = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int) x0;
    }


}
