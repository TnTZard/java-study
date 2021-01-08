package 设计模式.创建型模式.工厂方法模式;

/**
 * @Author: anzhi
 * @Date: 2020/12/24 15:11
 */
public class Application {

    public static void main(String[] args) {
        FruitFactory factory = new AppleFruitFactory();
        Fruit fruit = factory.produceFruit();
        fruit.eat();
    }

}
