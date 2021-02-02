package 剑指Offer.中等;

/**
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及
 * 条件判断语句（A?B:C）。
 * @Author: anzhi
 * @Date: 2021/2/1 9:34
 */
public class 求1加到n {


    /**
     * 逻辑运算符的短路效应
     * 常见的逻辑运算符有三种 &&  ||  !
     * if(A&&B)  若A为false，则B的判断不会执行
     * if(A||B)  若A为ture，则B的判断不会执行
     *
     *
     *
     * **/


    public static void main(String[] args) {

    }


    static int res = 0;
    public static int sumNums(int n) {
        boolean x = n > 1 && sumNums(n - 1) > 0;
        res += n;
        return res;
    }



}
