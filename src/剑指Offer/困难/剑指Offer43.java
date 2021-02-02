package 剑指Offer.困难;

/**
 * 1～n 整数中 1 出现的次数
 *
 * @Author: anzhi
 * @Date: 2021/2/2 11:38
 */
public class 剑指Offer43 {


    public static void main(String[] args) {
        System.out.println(countDigitOne(824883294));
    }

    public static int countDigitOne(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=1; i<=n; i++) {
            if (String.valueOf(i).contains("1")) {
                stringBuilder.append(i);
            }
        }
        int count = 0;
        for (char s : stringBuilder.toString().toCharArray()) {
            if ('1' == s) count++;
        }
        return count;
    }



}
