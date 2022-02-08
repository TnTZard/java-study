package 静态;

/**
 * @Author: anzhi
 * @Date: 2021/3/8 13:51
 */
public class HasStatic {

    private static int x = 100;

    public static void main(String[] args) {
        HasStatic h1 = new HasStatic();
        h1.x++;
        HasStatic h2 = new HasStatic();
        h2.x++;
        h1 = new HasStatic();
        h1.x++;
        HasStatic.x--;
        System.out.println("x=" + x);
    }


}
