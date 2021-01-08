package 动态代理.静态代理.proxy;

import 动态代理.静态代理.service.PieService;
import 动态代理.静态代理.service.PieServiceImpl;

/**
 * @Author: anzhi
 * @Date: 2020/12/21 14:19
 */
public class PieServiceProxy {

    private PieService pieService;

    public void makePie() {
        beforeMethod();
        pieService = new PieServiceImpl();
        pieService.makePie();
        afterMethod();
    }

    private void beforeMethod() {
        System.out.println("准备材料！");
    }

    private void afterMethod() {
        System.out.println("保鲜");
    }




}
