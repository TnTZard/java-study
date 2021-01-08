package 动态代理.静态代理;

import 动态代理.动态代理.DynamicProxy;
import 动态代理.动态代理.IceCreamService;
import 动态代理.动态代理.IceCreamServiceImpl;
import 动态代理.静态代理.proxy.CalculatorProxy;
import 动态代理.静态代理.proxy.PieServiceProxy;
import 动态代理.静态代理.service.Calculator;
import 动态代理.静态代理.service.CalculatorImpl;
import 动态代理.静态代理.service.PieService;
import 动态代理.静态代理.service.PieServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: anzhi
 * @Date: 2020/12/16 11:38
 */
public class Test {


    public static void main(String[] args) throws Exception {
//        CalculatorImpl target = new CalculatorImpl();
//        Calculator calculator = (Calculator) getProxy(target);
//        calculator.add(1, 2);
//        calculator.sub(2, 1);
//        PieServiceProxy proxy = new PieServiceProxy();
//        proxy.makePie();
        PieService pieServiceDynamicProxy = (PieService) new DynamicProxy(new PieServiceImpl()).proxy();
        pieServiceDynamicProxy.makePie();
        System.out.println("--------------------");
        IceCreamService iceCreamServiceDynamicProxy = (IceCreamService) new DynamicProxy(new IceCreamServiceImpl()).proxy();
        iceCreamServiceDynamicProxy.makeIceCream("\uD83C\uDF53");
    }

    private static Object getProxy(final Object target) throws Exception {
        Object proxy = Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println(method.getName()+"方法开始执行...");
                        Object result = method.invoke(target, args);
                        System.out.println(result);
                        System.out.println(method.getName()+"方法执行结束...");
                        return result;
                    }
                }
        );
        return proxy;
    }

}
