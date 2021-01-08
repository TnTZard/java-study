package 内部类;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

/**
 * @Author: anzhi
 * @Date: 2020/11/19 9:19
 */
public class Outer {

   public int age = 18;

   class Inner {
       public int age = 20;
       public void showAge() {
           int age = 25;
           System.out.println(age);
           System.out.println(this.age);
           System.out.println(Outer.this.age);
       }
   }
}


class Outer1 {
    private int age = 20;
    public void method() {
        final int age2 = 30;
        class Inner {
            public void show() {
                System.out.println(age);
                System.out.println(age2);
            }
        }
        Inner inner = new Inner();
        inner.show();
    }
}


class Outer2 {
    int age = 10;
    static int age2 = 20;
    public Outer2() {}
    static class Inner {
        public void method() {
            System.out.println();
            System.out.println(age2);
        }
    }

}




class Test {

    public static void main(String[] args) {
        Outer outer = new Outer();
        HashSet<String> set = new HashSet<>();
        Hashtable table = new Hashtable();
        HashMap<String, Object> map = new HashMap<>();
    }

}


