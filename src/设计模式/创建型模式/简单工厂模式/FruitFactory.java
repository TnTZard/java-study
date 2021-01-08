package 设计模式.创建型模式.简单工厂模式;

/**
 * @Author: anzhi
 * @Date: 2020/12/24 14:53
 */
public class FruitFactory {

    public Fruit produce(String name) {
        if ("apple".equals(name)) {
            return new Apple();
        } else {
            return null;
        }
    }

}
