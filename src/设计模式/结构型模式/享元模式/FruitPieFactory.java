package 设计模式.结构型模式.享元模式;

import java.util.HashMap;

/**
 * @Author: anzhi
 * @Date: 2020/12/24 11:16
 */
public class FruitPieFactory {

    private static final HashMap<String, FruitPie> PIE_HASH_MAP = new HashMap<>();

    public static FruitPie produce(String name) {
        FruitPie fruitPie = PIE_HASH_MAP.get(name);
        if (fruitPie == null) {
            System.out.println("没有" + name + "制作方法，学习制作...");
            fruitPie = new FruitPie(name);
            PIE_HASH_MAP.put(name, fruitPie);
        }
        return fruitPie;
    }


}
