package 设计模式.结构型模式.桥接模式;

/**
 * @Author: anzhi
 * @Date: 2020/12/24 14:28
 */
public class CarrotPie implements Pie{

    @Override
    public Pie makePie() {
        System.out.println("制作胡萝卜派\uD83E\uDD55\uD83E\uDD67");
        return new CarrotPie();
    }

    @Override
    public void getType() {
        System.out.println("蔬菜沙拉派");
    }
}
