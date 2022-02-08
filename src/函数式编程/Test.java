package 函数式编程;

import java.util.function.*;

/**
 * @author xiezq1
 * @version 1.0.0
 * @date 2022/1/28 11:20
 */
public class Test {

    public static void main(String[] args) {
        // lambda
        Consumer<String> consumer = s -> System.out.println(s);
        // 方法引用
        Consumer<String> consumer1 = System.out::println;



        // 非静态方法，使用对象实例的方法引用
        Person p = new Person();

        Function<Integer, Integer> function = p::buy;

        System.out.println("还剩"+function.apply(10)+"元");

        UnaryOperator<Integer> unaryOperator = p::buy;

        IntUnaryOperator intUnaryOperator = p::buy;

        // 使用类名 方法引用
        BiFunction<Person, Integer, Integer> biFunction = Person::buy;

        // 构造函数方法引用
        Supplier<Person> personSupplier = Person::new;
        System.out.println("创建了新对象 " + personSupplier.get());
    }





}
