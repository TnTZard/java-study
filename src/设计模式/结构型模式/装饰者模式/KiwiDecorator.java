package 设计模式.结构型模式.装饰者模式;

/**
 * @Author: anzhi
 * @Date: 2020/12/24 10:56
 */
public class KiwiDecorator extends AbstractDecorator {

    public KiwiDecorator(AbstractFruitSalad fruitSalad) {
        super(fruitSalad);
    }

    @Override
    public String remark() {
        return super.remark() + "加份猕猴桃\n";
    }

    @Override
    public int price() {
        return super.price() + 2;
    }
}
