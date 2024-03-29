package 函数式编程;

import java.util.function.Function;

/**
 * 级联表达式和柯里化
 *
 * 柯里化：把多个参数的函数转换为只有一个参数的函数
 * 高阶函数: 返回函数的函数
 *
 * @author xiezq1
 * @version 1.0.0
 * @date 2022/1/28 13:54
 */
public class CurryDemo {

    public static void main(String[] args) {
        // x + y 的级联表达式
        Function<Integer, Function<Integer, Integer>> function = x -> y -> x + y;
        System.out.println(function.apply(2).apply(3));


        Function<Integer, Function<Integer, Function<Integer, Integer>>> fun2 = x -> y -> z -> x+y+z;
        System.out.println(fun2.apply(2).apply(3).apply(4));

        int[] nums = {2, 3, 4};
        Function f = fun2;
        for (int i = 0; i < nums.length; i++) {
            if (f instanceof Function) {
                Object o = f.apply(nums[i]);
                if (o instanceof Function) {
                    f = (Function) o;
                } else {
                    System.out.println("调用结束：结果为：" + o);
                }
            }
        }
    }



}
