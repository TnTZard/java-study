package 常用常查;

import java.math.BigDecimal;

/**
 * @Author: anzhi
 * @Date: 2020/12/29 9:23
 */
public class 经纬度 {

    public static void main(String[] args) {
        System.out.println(change(115, 30, 0, 6));
        System.out.println(change(22, 46, 27.06, 6));
    }

    /**
     * 度分秒 -> 度
     * @param du
     * @param fen
     * @param miao
     * @param scale 保留几位小数
     * @return
     */
    public static double change(double du, double fen, double miao, int scale) {
        BigDecimal b = new BigDecimal(du + fen / 60 + miao / 60);
        return b.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }



}
