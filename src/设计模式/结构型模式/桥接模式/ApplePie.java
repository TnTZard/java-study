package 设计模式.结构型模式.桥接模式;

/**
 * @Author: anzhi
 * @Date: 2020/12/24 14:27
 */
public class ApplePie implements Pie {

    @Override
    public Pie makePie() {
        System.out.println("制作苹果派\uD83C\uDF4E\uD83E\uDD67");
        return new ApplePie();
    }

    @Override
    public void getType() {
        System.out.println("水果派");
    }
}
