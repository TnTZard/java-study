package 设计模式.结构型模式.桥接模式;

/**
 * @Author: anzhi
 * @Date: 2020/12/24 14:34
 */
public class JackStore extends Store{

    public JackStore(Pie pie) {
        super(pie);
    }

    @Override
    Pie makePie() {
        System.out.println("杰克的小店\uD83D\uDC92");
        return pie.makePie();
    }
}
