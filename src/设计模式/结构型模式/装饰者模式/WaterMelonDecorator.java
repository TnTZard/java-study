package 设计模式.结构型模式.装饰者模式;

/**
 * @Author: anzhi
 * @Date: 2020/12/24 10:59
 */
public class WaterMelonDecorator extends AbstractDecorator {

    public WaterMelonDecorator(AbstractFruitSalad fruitSalad) {
        super(fruitSalad);
    }

    @Override
    public String remark() {
        return super.remark() + "加份西瓜\n";
    }

    @Override
    public int price() {
        return super.price();
    }
}
