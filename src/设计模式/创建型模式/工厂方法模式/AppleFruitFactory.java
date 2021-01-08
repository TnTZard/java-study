package 设计模式.创建型模式.工厂方法模式;

/**
 * @Author: anzhi
 * @Date: 2020/12/24 15:10
 */
public class AppleFruitFactory extends FruitFactory {
    @Override
    public Fruit produceFruit() {
        return new Apple();
    }
}
