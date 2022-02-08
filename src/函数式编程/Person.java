package 函数式编程;

/**
 * @author xiezq1
 * @version 1.0.0
 * @date 2022/1/28 11:28
 */
public class Person {

    private int money = 100;

    public int buy(int money) {
        System.out.println("花掉了" + money + "元");
        this.money -= money;
        return this.money;
    }

}
