package 动态代理.静态代理.proxy;

import 动态代理.静态代理.service.Calculator;

/**
 * @Author: anzhi
 * @Date: 2020/12/16 11:35
 */
public class CalculatorProxy implements Calculator {

    private Calculator target;

    public CalculatorProxy(Calculator target) {
        this.target = target;
    }

    @Override
    public int add(int a, int b) {
        System.out.println("add方法开始...");
        int result = target.add(a, b);
        System.out.println("add方法结束...");
        return result;
    }

    @Override
    public int sub(int a, int b) {
        System.out.println("subtract方法开始...");
        int result = target.sub(a, b);
        System.out.println("subtract方法结束...");
        return result;
    }
}
