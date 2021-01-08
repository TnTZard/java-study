package 设计模式.结构型模式.装饰者模式;

/**
 * @Author: anzhi
 * @Date: 2020/12/24 11:00
 */
public class Application {

    public static void main(String[] args) {

        AbstractFruitSalad fruitSalad = new FruitSalad();
        fruitSalad = new KiwiDecorator(fruitSalad);
        fruitSalad = new KiwiDecorator(fruitSalad);
        fruitSalad = new WaterMelonDecorator(fruitSalad);
        System.out.println(fruitSalad.remark() + "价格是：" + fruitSalad.price());

    }

}
