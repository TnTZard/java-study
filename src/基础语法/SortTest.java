package 基础语法;

import java.util.*;

/**
 * @Author: anzhi
 * @Date: 2021/3/22 18:06
 */
public class SortTest {

    class Dog {
        public int age;
        public String name;
        public Dog(int age, String name) {
            super();
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Dog{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {

        Integer a = 300;
        Integer b = 300;
        int c = 300;
        System.out.println(a == b);

//        List<Dog> list = new ArrayList<>();
//        list.add(new SortTest().new Dog(25, "DogA"));
//        list.add(new SortTest().new Dog(15, "DogB"));
//        list.add(new SortTest().new Dog(7, "DogC"));
//        list.add(new SortTest().new Dog(8, "DogD"));
//        Collections.sort(list, new Comparator<Dog>() {
//            @Override
//            public int compare(Dog o1, Dog o2) {
//                System.out.println("o1:"+o1.age+"  o2:" + o2.age + "  result：" + (o1.age - o2.age));
//                return o1.age - o2.age;
//            }
//        });
//        System.out.println("倒序：" + list);
    }


}
