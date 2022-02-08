package 基础语法;

/**
 * @Author: anzhi
 * @Date: 2021/1/11 9:50
 */
public class B extends A{

    private static String a;

    private void a() {
        System.out.println("b方法");
    }

    static class BChild {
        void print() {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        BChild child = new BChild();
        child.print();
    }

}
