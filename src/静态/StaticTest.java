package 静态;

/**
 * @Author: anzhi
 * @Date: 2021/1/8 14:19
 */
public class StaticTest {

    static {
        System.out.println("hello");
    }

    static {
        System.out.println("world");
    }

    static int value = 666;

    public static void main(String[] args) {
        new StaticTest().method();
    }

    private void method() {
        int value = 123;
        System.out.println(this.value);
    }



}
