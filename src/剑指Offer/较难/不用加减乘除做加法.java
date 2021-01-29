package 剑指Offer.较难;

/**
 * @Author: anzhi
 * @Date: 2021/1/29 15:20
 */
public class 不用加减乘除做加法 {

    public static void main(String[] args) {
        System.out.println(add(156,177));
    }

    public static int add(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }


}
