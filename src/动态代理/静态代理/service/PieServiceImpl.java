package 动态代理.静态代理.service;

/**
 * @Author: anzhi
 * @Date: 2020/12/21 14:18
 */
public class PieServiceImpl implements PieService{

    @Override
    public void makePie() {
        System.out.println("制作\uD83E\uDD57派");
    }
}
