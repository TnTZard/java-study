package 设计模式.结构型模式.装饰者模式;

/**
 * @Author: anzhi
 * @Date: 2020/12/24 10:54
 */
public class FruitSalad extends AbstractFruitSalad {



    @Override
    public String remark() {
        return "水果（标准）\n";
    }

    @Override
    public int price() {
        return 9;
    }
}
