package 设计模式.创建型模式.简单工厂模式;

/**
 * @Author: anzhi
 * @Date: 2020/12/24 15:00
 */
public class Application {

    public static void main(String[] args) {
        FruitFactory factory = new FruitFactory();
        Fruit fruit = factory.produce("apple");
        fruit.eat();
    }

}
