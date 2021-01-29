package hashmap;

/**
 * @Author: anzhi
 * @Date: 2021/1/7 11:35
 */
public class Test {

    public static void main(String[] args) {
        //System.out.println( 1<<4 );
//        int k = Integer.valueOf(500);
//        int z = Integer.valueOf(500);
//        Integer d = Integer.valueOf(128);
//        Integer f = Integer.valueOf(128);
//        int a = 9527;
//        int b = 9527;
////        boolean c = true;
////        System.out.println(sun.misc.VM.getSavedProperty("java.lang.Integer.IntegerCache.high"));
//        System.out.println(k == z);
//        System.out.println(d == f);
//        System.out.println(a == b);
//

//        String s3 = s1.intern();
//        String s4 = s2.intern();
//        System.out.println(s3);
//        System.out.println(s4);
//        System.out.println(s3 == s4);

        String s1 = new String("hello");
//        String s2 = new String("hello");
//        String s5 = "hello";
//        String s6 = "hello";
//        System.out.println(s1 == s2);
//        System.out.println(s5 == s6);
        Test test = new Test();
        test.test();
    }

    class A {
        private int x;
        public A(int x) {
            this.x = x;
        }
    }

    private void test() {
        final A a = new A(1);
        a.x = 2;
        System.out.println(a.x);
    }

}
