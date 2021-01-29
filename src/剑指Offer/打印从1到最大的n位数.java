package 剑指Offer;

/**
 * @Author: anzhi
 * @Date: 2021/1/28 15:03
 */
public class 打印从1到最大的n位数 {

    /**
     *  1 9
     *  2 99
     *  3 999
     *  4 9999
     *  5 99999
     */


    public static void main(String[] args) {
        System.out.println();
    }

    public static int[] printNumbers(int n) {
//        Double x = Math.pow(10, n);
//        int length = x.intValue() -1;
        int length = (int) Math.pow(10, n) - 1;
        int[] res = new int[length];
        for (int i=0; i<length; i++) {
            res[i] = i + 1;
        }
        return res;
    }


}
