package 函数式编程;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * Stream流编程学习
 *
 * @author xiezq1
 * @version 1.0.0
 * @date 2022/1/28 14:04
 */
public class StreamStudy {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};

        // 外部迭代
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        System.out.println("结果为：" + sum);

        // 使用stream的内部迭代
        int sum1 = IntStream.of(nums).sum();
        System.out.println("结果为：" + sum1);

        // 惰性求值 就是终止没有调用的情况下，中间操作不会执行
        // map 中间操作 （返回stream的操作）
        // sum 终止操作
        int sum2 = IntStream.of(nums).map(i -> i*2).sum();
        IntStream.of(nums).map(StreamStudy::twiceNum);


        List<String> list = new ArrayList<>();
        // 集合创建
        list.stream();
        list.parallelStream();
        // 数组创建
        Arrays.stream(new int[]{2, 3, 4});
        //
        IntStream.of(1, 2, 3);
        IntStream.rangeClosed(1, 10);

        // 使用random创建一个无限流
        new Random().ints().limit(10);
        Random random = new Random();
        Stream.generate(() -> random.nextInt()).limit(20);


        // 中间操作
        String str = "my name is hello world";

        Stream.of(str.split(" "))
                .filter(s -> s.length() > 2)
                .map(s -> s.length())
                .forEach(System.out::println);

        // flatMap A->B属性(集合) 最终得到所有的A元素里面的所有B属性集合
        Stream.of(str.split(" "))
                .flatMap(s -> s.chars().boxed())
                .forEach(i -> System.out.println((char) i.intValue()));


        // peek 用于 debug 是个中间操作
        System.out.println("----------peek-----------");
        Stream.of(str.split(" "))
                .peek(System.out::println)
                .forEach(System.out::println);

        // limit 主要用于无限流
        new Random().ints().filter(i -> i > 100 && i < 10000)
                .limit(10)
                .forEach(System.out::println);

        // 终止操作
        String t1 = "my name is andy";
        t1.chars().parallel().forEach(i -> System.out.print((char) i));

        t1.chars().parallel().forEachOrdered(i -> System.out.print((char) i));

        // 收集到list
        List<String> collect = Stream.of(str.split(" ")).collect(Collectors.toList());
        System.out.println(collect);

        // 使用reduce拼接字符串
        Optional<String> reduce = Stream.of(str.split(" ")).reduce((s1, s2) -> s1 + "|" + s2);
        // 带初始化值得reduce
        String re = Stream.of(str.split(" ")).reduce("", (s1, s2) -> s1 + "|" + s2);
        System.out.println(reduce.orElse(""));
        System.out.println(re);
        // 计算所有单词总长度
        Integer length = Stream.of(str.split(" "))
                .map(s -> s.length())
                .reduce(0, (s1, s2) -> s1 + s2);
        System.out.println(length);

        Optional<String> max = Stream.of(str.split(" "))
                .max((s1, s2) -> s1.length() - s2.length());
        System.out.println(max.orElse(""));


        // 短路操作
        OptionalInt first = new Random().ints().findFirst();
        System.out.println(first.getAsInt());
    }


    public static int twiceNum(int i) {
        System.out.println("执行了乘2");
        return i * 2;
    }







}
