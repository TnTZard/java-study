package 常用常查;

/**
 * @author xiezq1
 * @version 1.0.0
 * @date 2021/10/2 22:36
 */
public class 数字转为十六进制 {

    public static void main(String[] args) {
        System.out.println(toHex(16));
    }

    public static String toHex(int num) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int u = num & 15;
            char c = (char) (u + '0');
            if (u >= 10) c = (char)(u - 10 + 'a');
            sb.append(c);
            num >>>= 4;
        }
        return sb.reverse().toString();
    }


}
