package 设计模式.结构型模式.装饰者模式;

/**
 * 创建一个抽象的装饰器
 * @Author: anzhi
 * @Date: 2020/12/24 10:51
 */
public class AbstractDecorator extends AbstractFruitSalad{

    private AbstractFruitSalad fruitSalad;

    public AbstractDecorator(AbstractFruitSalad fruitSalad) {
        this.fruitSalad = fruitSalad;
    }

    @Override
    public String remark() {
        return fruitSalad.remark();
    }

    @Override
    public int price() {
        return fruitSalad.price();
    }
}
