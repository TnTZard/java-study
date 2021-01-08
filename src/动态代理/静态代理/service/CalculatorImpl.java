package 动态代理.静态代理.service;

/**
 * @Author: anzhi
 * @Date: 2020/12/16 11:19
 */
public class CalculatorImpl implements Calculator {

    @Override
    public int add(int a, int b) {
        int result = a + b;
        return result;
    }

    @Override
    public int sub(int a, int b) {
        int result = a - b;
        return result;
    }
}
