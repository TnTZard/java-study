package 常用常查.单例模式;

/**
 * @Author: anzhi
 * @Date: 2021/3/29 15:15
 */
public class Singleton {

    private static volatile Singleton singleton;

    private Singleton() {}

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }





}
