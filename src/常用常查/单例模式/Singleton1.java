package 常用常查.单例模式;

/**
 * @Author: anzhi
 * @Date: 2021/3/29 15:18
 */
public class Singleton1 {

    private static final Singleton1 singleton1 = new Singleton1();

    private Singleton1() {}

    public static Singleton1 getInstance() {
        return singleton1;
    }


}
