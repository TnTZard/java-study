package 常用常查;

/**
 * @Author: anzhi
 * @Date: 2021/3/24 15:00
 */
public class 位运算 {


    public static void main(String[] args) {
//        System.out.println(count(32));

        System.out.println(Math.pow(10, -1.01));


    }

    public static int count(int n) {
        int count = 0;
        while (n > 0) {
            n = (n >> 1);
            count++;
        }
        return count-1;
    }



}
