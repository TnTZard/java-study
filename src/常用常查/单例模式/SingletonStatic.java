package 常用常查.单例模式;

/**
 * @Author: anzhi
 * @Date: 2021/3/29 15:29
 */
public class SingletonStatic {

    private static class SingletonHolder {
        private static final SingletonStatic INSTANCE = new SingletonStatic();
    }

    private SingletonStatic() {

    }

    public static SingletonStatic getInstance() {
        return SingletonHolder.INSTANCE;
    }


    public static void main(String[] args) {
        SingletonEnum.getInstance().print();
    }

}
