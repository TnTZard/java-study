package 动态代理.动态代理;

import 动态代理.动态代理.IceCreamService;

/**
 * @Author: anzhi
 * @Date: 2020/12/21 14:24
 */
public class IceCreamServiceImpl implements IceCreamService {

    @Override
    public void makeIceCream(String fruit) {
        System.out.println("制作" + fruit + "\uD83C\uDF66");
    }

}
