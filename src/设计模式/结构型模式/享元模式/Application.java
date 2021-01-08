package 设计模式.结构型模式.享元模式;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

/**
 * @Author: anzhi
 * @Date: 2020/12/24 11:20
 */
public class Application {

    private static final String[] PIE = {"🍇派", "🍈派", "🍓派", "🍒派"};

    public static void main(String[] args) {
        IntStream.range(0, 10).forEach(i -> {
            String name = PIE[(int) (Math.random() * PIE.length)];
            FruitPie fruitPie = FruitPieFactory.produce(name);
            fruitPie.setProductTime(LocalDateTime.now());
            fruitPie.make();
        });
    }
}
