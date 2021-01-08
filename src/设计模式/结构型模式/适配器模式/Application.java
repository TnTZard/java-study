package 设计模式.结构型模式.适配器模式;

/**
 * @Author: anzhi
 * @Date: 2020/12/24 11:10
 */
public class Application {
    public static void main(String[] args) {
        Pie pie = new RaspberryPieAdaptor();
        pie.make();
    }
}
