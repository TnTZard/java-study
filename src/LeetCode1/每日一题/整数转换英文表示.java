package LeetCode1.每日一题;

/**
 * @author xiezq1
 * @version 1.0.0
 * @date 2021/10/11 13:21
 */
public class 整数转换英文表示 {

    static String[] small = {
            "Zero",
            "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    static String[] medium = {
            "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    static String[] large = {
            "Billion", "Million", "Thousand", "",
    };

    static String num2Str(int x) {
        String ans = "";
        if (x >= 100) {
            ans += small[x / 100] + " Hundred ";
            x %= 100;
        }
        if (x >= 20) {
            ans += medium[x / 10] + " ";
            x %= 10;
        }
        if (x != 0) ans += small[x] + " ";
        return ans;
    }

    public static String numberToWords(int num) {
        if (num == 0) return small[0];
        StringBuilder sb = new StringBuilder();
        for (int i = (int)1e9, j = 0;  i >= 1; i /= 1000, j++) {
            if (num < i) continue;
            sb.append(num2Str(num / i) + large[j] + " ");
            num %= i;
        }
        while (sb.charAt(sb.length() - 1) == ' ') sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(numberToWords(11111));
    }
}
