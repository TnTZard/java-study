package 设计模式.结构型模式.桥接模式;

/**
 * @Author: anzhi
 * @Date: 2020/12/24 14:32
 */
public abstract class Store {

    protected Pie pie;

    public Store(Pie pie) {
        this.pie = pie;
    }

    abstract Pie makePie();

}
