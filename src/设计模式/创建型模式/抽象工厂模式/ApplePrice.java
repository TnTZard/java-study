package 设计模式.创建型模式.抽象工厂模式;

/**
 * @Author: anzhi
 * @Date: 2020/12/24 15:33
 */
public class ApplePrice extends Price {
    @Override
    public void pay() {
        System.out.println("苹果单价2元");
    }
}
