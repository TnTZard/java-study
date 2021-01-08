package 设计模式.结构型模式.适配器模式;

/**
 * @Author: anzhi
 * @Date: 2020/12/24 11:07
 */
public class RaspberryPieAdaptor extends Raspberry implements Pie {

    @Override
    public void make() {
        System.out.println("制作一个pie");
        super.addRaspberry();
    }
}
