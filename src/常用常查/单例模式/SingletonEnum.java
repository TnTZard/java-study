package 常用常查.单例模式;

/**
 * @Author: anzhi
 * @Date: 2021/3/29 15:25
 */
public enum SingletonEnum {

    INSTANCE;

    public static SingletonEnum getInstance() {
        return INSTANCE;
    }

    public void print() {
        System.out.println("hello");
    }

}
